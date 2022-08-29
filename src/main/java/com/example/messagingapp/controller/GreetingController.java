package com.example.messagingapp.controller;

import com.example.messagingapp.entity.Greeting;
import com.example.messagingapp.service.GreetingService;
import com.example.messagingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController{

    @Autowired
    IGreetingService greetingService;

    @Autowired
    GreetingService services;

    private static final String template="Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


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

    @GetMapping("/user")
    public String greetMessageWithUser(@RequestParam(value = "firstName", defaultValue = "") String firstName,
                                       @RequestParam(value = "lastName", defaultValue = "") String lastName){
        return services.greetingWithUser(firstName, lastName);
    }
    @PostMapping("/post")
    public Greeting saveGreeting(@RequestBody Greeting greetings){
        services.greetMessage(greetings);
        return greetings;
    }
    @GetMapping("/greetId/{id}")
    public Optional<Greeting> greetById(@PathVariable long id){
        return services.findById(id);
    }

    @GetMapping("/list")
    public List<Greeting> getAllData(){
        List<Greeting> response = services.recieveData();
        return response;
    }
}
