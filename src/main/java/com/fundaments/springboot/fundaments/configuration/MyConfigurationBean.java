/*
    archivo en el cual configuramos nuestra propias dependecias
 */
package com.fundaments.springboot.fundaments.configuration;

import com.fundaments.springboot.fundaments.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
