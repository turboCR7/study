package com.lmj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveMessage {

    //留言id
    private int id;

    //留言标题
    private String title;

    //留言内容
    private String content;

    //留言人姓名
    private String name;

    //留言人邮箱
    private String email;

    //留言时间
    private String time;

    @Override
    public String toString() {
        return "LeaveMessage{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
