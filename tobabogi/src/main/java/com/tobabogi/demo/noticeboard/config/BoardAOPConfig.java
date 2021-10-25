package com.tobabogi.demo.noticeboard.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.tobabogi.demo.noticeboard.aop")
public class BoardAOPConfig {

}
