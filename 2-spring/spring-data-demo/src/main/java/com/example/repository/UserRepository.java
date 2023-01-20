package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    // Spring data DSL
    Optional<User> findByEmail(String email);

    @Query("from User u where u.email =?1")
    Optional<User> findByEmailAddress(String emailAddress);

}
