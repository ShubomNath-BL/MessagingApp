package com.example.messagingapp.service;

import com.example.messagingapp.entity.Greeting;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService {
    private static final String template = "Hello world";
    private final AtomicLong counter = new AtomicLong();

    public Greeting greetingMessage() {

        return new Greeting(counter.incrementAndGet(), String.format(template));
    }
}
