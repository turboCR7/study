package com.lmj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Album {
    //相册编号
    int id;
    //相册名称
    String name;
    //简介
    String introduction;
    //图片
    String img;
    //用户id
    int userid;
}
