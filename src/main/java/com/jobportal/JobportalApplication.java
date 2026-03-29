package com.jobportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class JobportalApplication {
   


	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		String  adminPassword = encoder.encode("admin123");
		String userPassword = encoder.encode("user123");
		String recruiterPassword = encoder.encode("recruiter123");

		System.out.println("AdminPassword:"+ adminPassword);
		System.out.println("UserPassword:"+ userPassword);
        System.out.println("RecruiterPassword:"+ recruiterPassword);
		SpringApplication.run(JobportalApplication.class, args);
	}

}
