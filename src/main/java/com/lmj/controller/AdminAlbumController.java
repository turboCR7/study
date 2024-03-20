package com.lmj.controller;

import com.lmj.pojo.Album;
import com.lmj.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
public class AdminAlbumController {
    @Autowired
    AlbumService albumService;
    /*
       所有图片界面和分页(后台)
       */
    @GetMapping("/admin/allAlbum/{page}")
    public String allImg(@PathVariable int page, Model model){

        List<Album> albums = albumService.queryAllAlbum();
        //相册总数
        int albumSize = albums.size();
        model.addAttribute("albumSize",albumSize);
        //一页展示10条
        int pageSize = 10;
        //最多分多少页
        int maxPage = albumSize/pageSize;
        if (albumSize%pageSize!=0) maxPage++;
        //开始的文章的条数
        int start = (page-1)*pageSize > 0 ? (page-1)*pageSize:0;
        //将目标页数的文章信息传递过去
        // TODO: 2024/3/15
        List<Album> targetalbums = albumService.queryAlbumByLimit(start,pageSize);
        model.addAttribute("albums",targetalbums);
        //将下一页跟上一页信息传递过去
        int next = page+1;
        int prev = page-1;
        if (next>=maxPage) next = maxPage;
        if (prev<=1) prev = 1;
        model.addAttribute("next",next);
        model.addAttribute("prev",prev);
        return "admin/adminAllAlbum";

    }
    /*
       后台用户检索文章及分页
        */
    static String name = null;
    @RequestMapping("/admin/albumSearch/{page}")
    public String articleSearch(@PathVariable int page,String key,Model model){
        //记录第一次传进来的name用静态变量保存
        if (key!=null) name = key;
        //查询所有相关的图片
        List<Album> albums = albumService.queryAlbumByNameLimit("%"+name+"%", 0, 9999);
        int albumSize = albums.size();

        model.addAttribute("albumSize",albumSize);
        //一页展示多少条
        int pageSize = 10;
        //最多有多少页
        int maxPage = albumSize/pageSize;
        if (albumSize%pageSize!=0) maxPage++;
        //查询当前页数的文章信息
        int start = (page-1)*pageSize > 0 ? (page-1)*pageSize:0;
        List<Album> targetAlbum = albumService.queryAlbumByNameLimit("%"+name+"%", start, pageSize);
        model.addAttribute("albums",targetAlbum);
        //上一页下一页的页数传递过去
        int next = page+1;
        int prev = page-1;
        if (next>=maxPage) next = maxPage;
        if (prev<=1) prev = 1;
        model.addAttribute("next",next);
        model.addAttribute("prev",prev);
        return "admin/adminAllAlbum";
    }

    /*
   打开添加相册信息界面
    */
    @GetMapping("/admin/addAlbum")
    public String toUpdateUserInfo() {
        return "admin/adminAddAlbumInfo";
    }
    /*
    保存普通用户添加相册信息
     */
    @PostMapping("/admin/addAlbumInfo")
    public String addAlbumInfo(@RequestParam("name") String name, String introduction, @RequestParam("img") MultipartFile img, HttpSession session) {
         /*
        上传头像图片到静态资源文件夹中
         */
        if (!img.isEmpty()) {
            //获取文件名
            String fileName = img.getOriginalFilename();

            // 获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            // 文件上传路径
            String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\imgs\\upload\\commonUser\\";

            // 解决中文问题,liunx 下中文路径,图片显示问题
            fileName = UUID.randomUUID() + suffixName;
            File dest = new File(filePath + fileName);
            // 检测是否存在目录
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                //上传
                img.transferTo(dest);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String realPath = "/imgs/upload/commonUser/" + fileName;

            Album album=new Album();
            album.setName(name);
            album.setIntroduction(introduction);
            album.setUserid((Integer) session.getAttribute("id"));
            album.setImg(realPath);
            albumService.addAlbum(album);
            System.out.println("________________________________"+(Integer)session.getAttribute("id") +"__________________________________");


        }else{
            System.out.println("________________________________没有添加图片__________________________________");
        }

        return "redirect:/admin/addAlbum";
    }

    /*
       普通用户删除相册
        */
    @GetMapping("/admin/deleteAlbum/{id}")
    public String commonDeleteAlbum(@PathVariable int id){
        albumService.deleteAlbum(id);
        return "redirect:/admin/allAlbum/1";
    }

    /*
   用户更新相册
    */
    @GetMapping("/admin/toUpdateAlbum/{id}")
    public String toUpdateAlbum(@PathVariable int id,Model model){
        //将需要更新的文章信息传递过去
        Album album = albumService.queryAlbumById(id);
        model.addAttribute("album",album);
//        albumService.deleteAlbum(id);
        return "admin/updateAdminAddAlbumInfo";
    }


    @PostMapping("/admin/UpdateAlbum")
    public String UpdateAlbum( int id,String name,String introduction, @RequestParam("img") MultipartFile img){
        //将需要更新的文章信息传递过去
        //获取文件名
        String fileName = img.getOriginalFilename();

        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 文件上传路径
        String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\imgs\\upload\\commonUser\\";

        // 解决中文问题,liunx 下中文路径,图片显示问题
        fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if ( !dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            //上传
            img.transferTo(dest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String realPath = "/imgs/upload/commonUser/" + fileName;

        albumService.updateAlbum(id,name,introduction,realPath);

        System.out.println("+++++++++++++++++++++++++++++++");
        return "redirect:/admin/allAlbum/1";
    }
}
