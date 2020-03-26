package com.aki.ajaxwait;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebSecurityConfig implements WebMvcConfigurer {

    //直接访问页面的简单写法
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //注册界面
        registry.addViewController("ajaxHTML").setViewName("ajaxHTML");
    }
}
