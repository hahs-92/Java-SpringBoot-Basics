package com.fundaments.springboot.fundaments.bean;

public class MyBeanImplement implements MyBean {
    @Override
    public void print() {
        System.out.println("Hi from my own implement");
    }
}
