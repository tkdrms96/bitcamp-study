package com.tobabogi.demo.noticeboard.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@MapperScan(basePackages = "com.tobabogi.demo.noticeboard.mapper")
@ComponentScan(basePackages = "com.tobabogi.demo.noticeboard.service")
@Import(BoardAOPConfig.class)
public class NoticeBoardRootConfig {
}
