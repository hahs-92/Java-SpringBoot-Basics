package com.fundaments.springboot.fundaments.bean;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class MyBeanWithDependencyImpl implements MyBeanWithDependecy {

    Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImpl.class);

    //llamamos a otra dependecy
    private MyOperation myOperation;

    //recibe otra dependecia
    public MyBeanWithDependencyImpl(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependecy() {
        LOGGER.info("Hemos ingresado al metodo printWithDependecy");
        int number = 6;
        LOGGER.debug("El numero enviado desde printWithDependecy: " + number);
        System.out.println("Hi from an Impl with Dependency");
        System.out.println(myOperation.sum(number));
    }
}
