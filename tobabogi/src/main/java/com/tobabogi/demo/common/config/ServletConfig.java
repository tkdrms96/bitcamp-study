package com.tobabogi.demo.common.config;


import com.tobabogi.demo.common.converter.StringToLocalDateTimeConverter;
import com.tobabogi.demo.eventboard.config.EventBoardServletConfig;
import com.tobabogi.demo.noticeboard.config.NoticeBoardServletConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Import({NoticeBoardServletConfig.class, EventBoardServletConfig.class})
@ComponentScan(basePackages = {"com.tobabogi.demo.common.exception","com.tobabogi.demo.common.controller"})

public class ServletConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToLocalDateTimeConverter());
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {

        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/views/");
        bean.setSuffix(".jsp");
        registry.viewResolver(bean);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //webapp resources folder
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

}
