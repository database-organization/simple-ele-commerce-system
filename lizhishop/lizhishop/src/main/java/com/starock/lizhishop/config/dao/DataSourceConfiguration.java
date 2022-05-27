package com.starock.lizhishop.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

@Configuration
//这个注解标识的类中申明一个或多个@Bean方法，Spring容器可以使用这些方法来注入Bean
@MapperScan("com.starock.lizhishop.dao")
public class DataSourceConfiguration {
    @Value("${jdbc.driver}")
    private String jdbcDriver;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String jdbcUsername;
    @Value("${jdbc.password}")
    private String jdbcPassword;

    //这是一个数据库连接池，用来提升后端性能，简单地说就是在程序启动的时候就创建很多半成品
    //数据库链接对象，这样更有理由处理并发请求，节省内存提高效率，给每一给连接对象配置了JDBC
    @Bean(name = "dataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(jdbcDriver);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(jdbcUsername);
        dataSource.setPassword(jdbcPassword);
        dataSource.setAutoCommitOnClose(false);
        return dataSource;
    }
}
