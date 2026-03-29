package com.jobportal.controller;

import com.jobportal.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.jobportal.entity.Application;
import com.jobportal.repository.ApplicationRepository;
import com.jobportal.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/applications")
public class ApplicationController {
    
    private final ApplicationRepository applicationRepository;
    private final UserRepository userRepository;

    public ApplicationController(ApplicationRepository applicationRepository,
        UserRepository userRepository){
        this.applicationRepository = applicationRepository;
        
        this.userRepository = userRepository;
    }
    @PostMapping
    public Application applyjob(@RequestBody Application application,Authentication authentication){
        String email = authentication.getName();
        User user = userRepository.findByEmail(email).orElse(null);
       
        application.setUser(user);
        return applicationRepository.save(application);
    }
    @GetMapping
      public List<Application> getAlApplications(){
        return applicationRepository.findAll();
      }
    @GetMapping("/job/{jobId}")
    public List <Application>getApplicationsByJob(@PathVariable Long jobId){
        
        return applicationRepository.findByJob_Id(jobId);
    }
}
