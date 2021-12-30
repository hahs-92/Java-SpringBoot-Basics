package com.fundaments.springboot.fundaments.configuration;

import com.fundaments.springboot.fundaments.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fundaments.springboot.fundaments.bean.*;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:connection.properties")
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {
    //estos valores estan en el archivo application.properties
    @Value("${value.first_name}")
    private String firstName; // se guarda en esta variable

    @Value("${value.last_name}")
    private  String lastName;

    @Value("${value.random}")
    private  String random;

    //connection properties
    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${driver}")
    private String driver;

    @Value("${username}")
    private String userName;

    @Value("${password}")
    private String password;

    //ahora necesitamos un Bean para utilizarlas
    //esta interface y clase la creamos en bean folder
    @Bean
    public MyBeanWithProperties function() {
        return new MyBeanWithPropertiesImplement(firstName, lastName);
    }

    //bean h2-databse - spring nos inyectara esta dependecias
    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driver);
        dataSourceBuilder.url(jdbcUrl);
        dataSourceBuilder.username(userName);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
    }

}
