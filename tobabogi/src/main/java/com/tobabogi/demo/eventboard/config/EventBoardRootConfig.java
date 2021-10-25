package com.tobabogi.demo.eventboard.config;


import com.tobabogi.demo.noticeboard.config.BoardAOPConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@MapperScan(basePackages = "com.tobabogi.demo.eventboard.mapper")
@ComponentScan(basePackages = "com.tobabogi.demo.eventboard.service")
@Import(EventBoardAOPConfig.class)
public class EventBoardRootConfig {

}
