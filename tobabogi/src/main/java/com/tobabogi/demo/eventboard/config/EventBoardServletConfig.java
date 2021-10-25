package com.tobabogi.demo.eventboard.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@ComponentScan(basePackages = "com.tobabogi.demo.eventboard.controller")
public class EventBoardServletConfig implements WebMvcConfigurer {

}
