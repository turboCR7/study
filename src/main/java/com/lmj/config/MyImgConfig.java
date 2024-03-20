package com.lmj.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//解决上传文件后,需重新打包才能访问静态资源的问题   ****
@Configuration
public class MyImgConfig implements WebMvcConfigurer {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            /*System.out.println("配置文件已经生效");*/
            try {
                registry.addResourceHandler("/imgs/upload/**").addResourceLocations("file:" + System.getProperty("user.dir") + "\\src\\main\\resources\\static\\imgs\\upload\\");

            }catch (RuntimeException e) {
                System.out.println("访问失败");
             }catch (Exception e){
                System.out.println("异常");
            }
        }
    }
