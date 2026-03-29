package com.jobportal.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.jobportal.entity.Job;
import com.jobportal.repository.JobRepository;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private final JobRepository jobRepository;

    public JobController(JobRepository jobRepository){
        this.jobRepository = jobRepository;
    }
    @PostMapping
    public Job createJob (@RequestBody Job job){
        return jobRepository.save(job);
    }
    @GetMapping
     public List<Job> getAllJobs(){
        return jobRepository.findAll();
     }
    @GetMapping("/{id}")
    public Job getJobById(@PathVariable Long id){
        return jobRepository.findById(id).orElse(null);
    }
    
    
}
