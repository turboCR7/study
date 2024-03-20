package com.lmj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    //用户id
    private int id;

    //用户角色(1普通用户  2管理员)
    private int roleId;

    //用户名 用于登陆
    private String username;

    //密码
    private String password;

    //盐值
    private String salt;

    //真实姓名
    private String trueName;

    //性别(0女 1男)
    private int gender;

    //qq
    private String qq;

    //wechat
    private String wechat;

    //个人简介
    private String personalBrief;

    //个人头像url
    private String avatarImgUrl;



    public User(String username, String password, String trueName, int gender, String qq, String wechat, String personalBrief, String avatarImgUrl) {
        this.username = username;
        this.password = password;
        this.trueName = trueName;
        this.gender = gender;
        this.qq = qq;
        this.wechat = wechat;
        this.personalBrief = personalBrief;
        this.avatarImgUrl = avatarImgUrl;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", trueName='" + trueName + '\'' +
                ", gender=" + gender +
                ", qq='" + qq + '\'' +
                ", wechat='" + wechat + '\'' +
                ", personalBrief='" + personalBrief + '\'' +
                ", avatarImgUrl='" + avatarImgUrl + '\'' +
                '}';
    }
}
