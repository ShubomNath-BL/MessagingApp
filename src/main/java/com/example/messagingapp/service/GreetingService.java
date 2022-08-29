package com.example.messagingapp.service;

import com.example.messagingapp.entity.Greeting;
import com.example.messagingapp.repo.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService{

    @Autowired
    Repo repository;
    private static final String template = "Hello world";
    private final AtomicLong counter = new AtomicLong();

    @Override
    public Greeting greetingMessage() {

        return new Greeting(counter.incrementAndGet(), String.format(template));
    }

    public String greetingWithUser(String firstName, String lastName){
        if(firstName.isEmpty() && lastName.isEmpty()){
            return template;
        } else if (firstName.equals("") && !lastName.equals("")) {
            return "Hello " + lastName;
        }
        else if (!firstName.equals("") && lastName.equals("")) {
            return "Hello " + firstName;
        }
        return "Welcome " + firstName +" "+lastName;
    }

    public Greeting greetMessage(Greeting greetings) {
        repository.save(greetings);
        return greetings;
    }

    public Optional<Greeting> findById(long id) {
        return repository.findById(id);
    }

    public List<Greeting> recieveData() {
        List<Greeting> getList = repository.findAll();
        return getList;
    }

    public Greeting deleteDataById(long id) {
        repository.deleteById(id);
        return null;
    }
}
