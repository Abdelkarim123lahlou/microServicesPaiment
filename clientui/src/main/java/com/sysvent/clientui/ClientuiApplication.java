package com.sysvent.clientui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
/***
 * Enabling feigne and don't forget to add dependancy to pom.xml
 * the annotation sed to feigne to scann the package "com.sysvent.clientui" to search if there is any feign client on it
 * */
@EnableFeignClients("com.sysvent.clientui")

public class ClientuiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientuiApplication.class, args);
    }

}
