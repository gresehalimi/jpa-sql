package com.example.jpasql.configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration
public class ControllerConfig {
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/enigma").setViewName("enigma");
        registry.addViewController("/login").setViewName("login");
    }
}
