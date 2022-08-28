package com.example.messagingapp.controller;

import com.example.messagingapp.entity.Greeting;
import com.example.messagingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    private static final String template="Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    public IGreetingService greetingService = new IGreetingService() {
        @Override
        public Greeting greetingMessage() {
            return null;
        }
    };


    @GetMapping(value = {"","/","/home"})
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    @GetMapping("/{name}")
    public Greeting greetings(@PathVariable String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    @GetMapping("/service")
    public Greeting greeting() {
        return greetingService.greetingMessage();
    }
}
