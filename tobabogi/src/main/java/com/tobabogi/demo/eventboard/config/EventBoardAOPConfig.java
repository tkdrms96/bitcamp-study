package com.tobabogi.demo.eventboard.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.tobabogi.demo.eventboard.aop")
public class EventBoardAOPConfig {
}
