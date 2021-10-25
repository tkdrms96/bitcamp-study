package com.tobabogi.demo.common.config;

import com.tobabogi.demo.common.config.RootConfig;
//import com.tobabogi.demo.security.config.SecurityConfig;
//import com.tobabogi.demo.security.config.SecurityServletConfig;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.SecurityConfig;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;

@Log4j2
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {

        log.info("1----------------------------");
        log.info("1----------------------------");

        return new Class[]{RootConfig.class}; //, SecurityConfig.class
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {

        log.info("2----------------------------");
        log.info("2----------------------------");

        return new Class[]{ServletConfig.class}; // , SecurityServletConfig.class
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter uft8Filter = new CharacterEncodingFilter();
        uft8Filter.setEncoding("UTF-8");
        uft8Filter.setForceEncoding(true);

        return new Filter[]{uft8Filter};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {

        //registration.setInitParameter("throwExceptionIfNoHandlerFound","true");

        MultipartConfigElement multipartConfigElement
                = new MultipartConfigElement("/Users/include-hoany/upload/temp", 1024*1024*10,1024*1024*20, 1024*1024*1 );

        registration.setMultipartConfig(multipartConfigElement);

    }

}
