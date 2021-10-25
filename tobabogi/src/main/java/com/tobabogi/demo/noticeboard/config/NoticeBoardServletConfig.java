package com.tobabogi.demo.noticeboard.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@ComponentScan(basePackages = "com.tobabogi.demo.noticeboard.controller")
public class NoticeBoardServletConfig implements WebMvcConfigurer {
}
