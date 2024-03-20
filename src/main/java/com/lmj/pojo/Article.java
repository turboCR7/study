package com.lmj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import static com.lmj.utils.MyUtils.formatTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    //文章id  主键
    private int id;

    //文章作者id
    private int  userid;
    //文章作者
    private String author;

    //文章标题
    private  String articleTitle;

    //文章内容
    private String articleContent;

    //文章类型
    private String articleType;

    //文章标签
    private String articleTags;

    //创建时间
    private String publishDate;

    //最后一次更改时间
    private String updateDate;

    //文章喜欢数
    private int likes;

    public Article(String author, String articleTitle, String articleContent, String articleType, String articleTags,int id) {
        this.author = author;
        this.articleTitle = articleTitle;
        this.articleContent = articleContent;
        this.articleType = articleType;
        this.articleTags = articleTags;
        this.userid=id;
        //自己传当前的时间
        this.updateDate = formatTime(new Date());
    }



    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articleType='" + articleType + '\'' +
                ", articleTags='" + articleTags + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", likes=" + likes +
                '}';
    }
}
