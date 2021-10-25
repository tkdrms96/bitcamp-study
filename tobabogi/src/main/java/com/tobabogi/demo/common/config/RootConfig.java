package com.tobabogi.demo.common.config;

import com.tobabogi.demo.eventboard.config.EventBoardRootConfig;
import com.tobabogi.demo.localboard.config.LocalBoardRootConfig;
import com.tobabogi.demo.noticeboard.config.NoticeBoardRootConfig;
import com.tobabogi.demo.qnaboard.config.QnaBoardRootConfig;
import org.springframework.context.annotation.Import;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.*;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import java.util.ArrayList;

@Configuration
@EnableTransactionManagement
@Import({NoticeBoardRootConfig.class,EventBoardRootConfig.class}) //, QnaBoardRootConfig.class EventBoardRootConfig.class, LocalBoardRootConfig.class,
public class RootConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory()throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());

        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public DataSource dataSource(){
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
        config.setJdbcUrl("jdbc:log4jdbc:mysql://tobabogi2.cgyceoshvren.ap-northeast-2.rds.amazonaws.com:3306/tobabogi_db");
        config.setUsername("soongaek");
        config.setPassword("q5JvZ&(3f7j]*%E");
        HikariDataSource dataSource = new HikariDataSource(config);
        return dataSource;
    }

    @Bean
    public TransactionManager getTransaction() {
        return new DataSourceTransactionManager(dataSource());
    }
}