package com.lmj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FriendLink {

    //友联id
    private int id;

    //博客名字
    private String  blogName;

    //博客链接
    private String url;





    @Override
    public String toString() {
        return "friendLink{" +
                "id=" + id +
                ", blogName='" + blogName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
