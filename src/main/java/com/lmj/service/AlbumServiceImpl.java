package com.lmj.service;

import com.lmj.mapper.AlbumMapper;
import com.lmj.pojo.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl  implements AlbumService{

    @Autowired
    AlbumMapper albumMapper;

    @Override
    public List<Album> queryAllAlbum() {
        return albumMapper.queryAllAlbum();
    }

    @Override
    public int addAlbum(Album album) {
        return albumMapper.addAlbum(album);
    }

    @Override
    public int deleteAlbum(int id) {
        return albumMapper.deleteAlbum(id);
    }
    // TODO: 2024/3/15
    @Override
    public List<Album> queryAlbumByNameLimit(String name, int start, int pageSize) {
        return albumMapper.queryAlbumByNameLimit(name,start,pageSize);
    }

    @Override
    public Album queryAlbumById(int id) {
        return albumMapper.queryAlbumById(id);
    }

    @Override
    public void updateAlbum(int id, String name, String introduction, String img) {
        albumMapper.updateAlbum(id,name,introduction,img);
    }


    @Override
    public List<Album> queryAlbumByLimit(int start, int pageSize) {
        return albumMapper.queryAlbumByLimit(start,pageSize);
    }
}
