package com.jobportal.controller;

import com.jobportal.entity.User;
import com.jobportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
   
    public String register(@RequestBody User user){

        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            return "Email already exists!";
        }
        user.setPassword(passwordEncoder.encode(
            user.getPassword()));
            user.setRole("USER");
            userRepository.save(user);
        return "user registered successfully!";
    }
}
