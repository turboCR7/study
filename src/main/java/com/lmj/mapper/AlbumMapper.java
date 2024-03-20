package com.lmj.mapper;

import com.lmj.pojo.Album;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AlbumMapper {
    //查询所有图片
    List<Album> queryAllAlbum();
    //分页查询limit
    List<Album> queryAlbumByLimit(int start,int pageSize);
    //插入一条图片信息
    int addAlbum(Album album);
    //删除图片
    int deleteAlbum(int id);
    //查找图片

    //文章检索并分页limit
    List<Album> queryAlbumByNameLimit(@Param("name") String name, @Param("start") int start, @Param("pageSize") int pageSize);
    //根据图片id查找
    Album queryAlbumById(int id);
    //更新相册
    void updateAlbum(int id, String name, String introduction, String img);
}
