/*
    archivo en el cual configuramos nuestra propias dependecias
 */
package com.fundaments.springboot.fundaments.configuration;

import com.fundaments.springboot.fundaments.bean.*;
import org.springframework.boot.jdbc.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MyConfigurationBean {
    @Bean
    public MyBean beanOperation() {
        //return new MyBeanImplement();
        //ahora vamos a implementar otra clase
        return new MyBean2Implement();
    }

    @Bean
    public MyOperation beanOperationOperation() {
        return new MyOperationImplement();
    }

    //cuando una dependencia recibe otra dependencia
    @Bean
    public MyBeanWithDependecy beanOpWithDependency(MyOperation myOperation) {
        return new MyBeanWithDependencyImpl(myOperation);
    }

    //bean h2-databse - spring nos inyectara esta dependecias
    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:men:testdb");
        dataSourceBuilder.username("sa");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();
    }
}
