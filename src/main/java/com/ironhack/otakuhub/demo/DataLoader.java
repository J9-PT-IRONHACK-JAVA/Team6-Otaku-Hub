package com.ironhack.otakuhub.demo;

import com.ironhack.otakuhub.model.Userr;
import com.ironhack.otakuhub.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log
@Profile("demo")
public class DataLoader {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @EventListener(ApplicationReadyEvent.class)
    public void storeUser(){
        log.info("Starting demo user loading...");
        Userr user1 = new Userr("user", passwordEncoder.encode("user"), "ROLE_USER");
        userRepository.save(user1);
        log.info("User " + user1.getUsername() + " was created successfully");

        Userr user2 = new Userr("admin", passwordEncoder.encode("admin"), "ROLE_USER, ROLE_ADMIN");
        userRepository.save(user2);
        log.info("User " + user2.getUsername() + " was created successfully");
        log.info("Finished demo user loading.");
    }

}
