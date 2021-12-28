package com.fundaments.springboot.fundaments.bean;

public class MyBeanWithDependencyImpl implements MyBeanWithDependecy {

    //llamamos a otra dependecy
    private MyOperation myOperation;

    //recibe otra dependecia
    public MyBeanWithDependencyImpl(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependecy() {
        int number = 6;
        System.out.println("Hi from an Impl with Dependency");
        System.out.println(myOperation.sum(number));
    }
}
