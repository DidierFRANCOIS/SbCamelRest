package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class TestBeanInject {

    public String doSomething(String body) {
        return null ; // foo.hello(body);
    }
}