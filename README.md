 

一个小小的个人博客系统

但是功能俱全的博客系统~!

 
``` 
 
```
 
## 技术栈

> 1. SpringBoot
> 2. Html
> 3. CSS
> 4. JavaScript
> 5. JQuery
> 6. AmazeUI
> 7. Thymeleaf
> 8. druid数据源
> 9. Maven构建工具
> 10. Mybatis持久层
> 11. Mysql数据库

## 功能

- 登录模块,注册模块, 
- 文章详情, 文章分类详情, 文章标签详情
- 友链详情
- 富文本写文章模块, 管理系统注册过的用户, 用户密码找回功能
- 文章管理模块, 用户留言管理,友情链接管理, 个人独特信息修改
- 文章楼中楼评论管理

## 数据库说明

1. 数据库名为blog，如需更改，更改application.yml中的配置文件即可
2. 数据库的sql文件，已上传至sql文件夹中

3. 数据库字段详解

**PS: 本博客系统设置的超级管理员只存在一个，roleId为2 即是本系统的管理员，如若数据库出现roleId为2的不止一位用户，优先选取第一位作为超级管理员用户（也就是博主）**

## 快速启动

1. 配置开发环境：
    * [MySQL](https://dev.mysql.com/downloads/mysql/)
    * [JDK1.8或以上](http://www.oracle.com/technetwork/java/javase/overview/index.html)
    * [Maven](https://maven.apache.org/download.cgi)
2. 数据库依次导入sql下的数据库文件
    * blog.sql
    * sql字段详解
3. 使用IDEA开发工具打开此项目,  等待maven解决依赖问题, 启动项目即可
此时，浏览器打开，输入网址`http://localhost:8080, 此时进入博客首页~
 
