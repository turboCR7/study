package com.lmj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    //评论id
    private int id;

    //父评论id
    private int pid;

    //评论的文章id
    private int articleId;

    //评论者的username
    private String  answererName;

    //被评论者的username
    private String respondentName;

    //评论时间
    private String commentDate;

    //评论内容
    private String commentContent;

    //评论者的头像信息
    private String avatarImgUrl;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", pid=" + pid +
                ", articleId=" + articleId +
                ", answererName='" + answererName + '\'' +
                ", commentDate='" + commentDate + '\'' +
                ", commentContent='" + commentContent + '\'' +
                ", avatarImgUrl='" + avatarImgUrl + '\'' +
                '}';
    }
}
