package com.example.messagingapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Greeting {

    @Id
    private long id;
    private String content;
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Greeting() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Greeting [id=" + id + ", message=" + content + ", firstName=" + firstName +
                ", lastName=" + lastName +"]";
    }
}
