package com.ironhack.otakuhub.demo;

import com.ironhack.otakuhub.model.User;
import com.ironhack.otakuhub.repository.UserRepository;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.SQLIntegrityConstraintViolationException;

@Component
@RequiredArgsConstructor
@Log
@Profile("demo")
public class DataLoader {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @EventListener(ApplicationReadyEvent.class)
    public void storeUser(){
       try {
            log.info("Starting demo user loading...");
            User user1 = new User("user", passwordEncoder.encode("user"), "ROLE_USER");
            userRepository.save(user1);
            log.info("User " + user1.getUsername() + " was created successfully");

            User user2 = new User("admin", passwordEncoder.encode("admin"), "ROLE_USER, ROLE_ADMIN");
            userRepository.save(user2);
            log.info("User " + user2.getUsername() + " was created successfully");
            log.info("Finished demo user loading.");
        } catch (Exception e){
           System.out.println("Users exist already in the database");
           System.out.println(e.getMessage());
           System.out.println(e.getCause());

       }
    }

}
