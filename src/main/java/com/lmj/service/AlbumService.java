package com.lmj.service;

import com.lmj.pojo.Album;

import java.util.List;

public interface AlbumService {
    //查询所有图片
    List<Album> queryAllAlbum();
    //分页查询limit
    List<Album> queryAlbumByLimit(int start,int pageSize);
    //插入一条图片信息
    int addAlbum(Album album);
    //删除图片
    int deleteAlbum(int id);
    //查找图片
    List<Album> queryAlbumByNameLimit(String name, int start, int pageSize);
    //根据图片id查找
    Album queryAlbumById(int id);

    void updateAlbum(int id, String name, String introduction, String img);
}
