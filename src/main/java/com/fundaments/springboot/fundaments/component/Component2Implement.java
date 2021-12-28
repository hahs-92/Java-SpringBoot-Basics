package com.fundaments.springboot.fundaments.component;

import org.springframework.stereotype.Component;

@Component
public class Component2Implement implements ComponentDependency{
    @Override
    public void greet() {
        System.out.println("Hi from my component2");
    }
}
