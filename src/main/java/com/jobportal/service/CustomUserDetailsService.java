package com.jobportal.service;
import com.jobportal.entity.User;
import com.jobportal.repository.UserRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService 
implements UserDetailsService {
     
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    public CustomUserDetailsService(UserRepository
         userRepository, PasswordEncoder 
         passwordEncoder){
            this.userRepository = 
            userRepository;
            this.passwordEncoder = 
            passwordEncoder;
        }
      public User registerUser(User user){
        user.setPassword(passwordEncoder.encode(
            user.getPassword()));
            return userRepository.save(user);
      }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email)
                   .orElseThrow(()->new
               UsernameNotFoundException("User not found") );
                   

        

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                Collections.singleton(
                        new SimpleGrantedAuthority("ROLE_" + user.getRole())
                )
        );
    }
}

