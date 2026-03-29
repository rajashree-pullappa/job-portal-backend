package com.jobportal.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity 
public class SecurityConfig {
     
     @Bean
     public PasswordEncoder passwordEncoder(){
       return new BCryptPasswordEncoder();
       
     }
     
    @Bean
    public SecurityFilterChain 
    securityFilterChain(HttpSecurity http) 
    throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
             .requestMatchers("/applications/**").permitAll()
             .requestMatchers("/jobs/**").permitAll()
            .requestMatchers("/admin/**").hasRole("ADMIN")
            .requestMatchers("/user/**").hasRole("USER")
             
                
             
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .disable())
               .httpBasic(httpBasic -> httpBasic.disable());
           

        return http.build();
    }
}
