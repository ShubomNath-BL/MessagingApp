package com.example.messagingapp.repo;

import com.example.messagingapp.entity.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<Greeting, String> {
}
