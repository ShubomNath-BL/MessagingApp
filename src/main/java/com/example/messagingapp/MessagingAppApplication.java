package com.example.messagingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MessagingAppApplication {

    public static void main(String[] args) {
        System.out.println("Welcome to Messaging App");
        SpringApplication.run(MessagingAppApplication.class, args);
    }

}
