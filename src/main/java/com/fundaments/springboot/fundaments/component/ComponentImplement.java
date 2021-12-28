package com.fundaments.springboot.fundaments.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplement implements ComponentDependency{
    @Override
    public void greet() {
        System.out.println("Hi from my Component");
    }
}
