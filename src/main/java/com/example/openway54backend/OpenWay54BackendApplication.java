package com.example.openway54backend;

import com.example.openway54backend.Model.User;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
@MappedTypes(User.class)
@MapperScan("com.example.test.interfaces")
public class OpenWay54BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenWay54BackendApplication.class, args);
    }

}
