package com.jobportal.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "application")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String email;
        
       
        @ManyToOne
        @JoinColumn(name = "job_id")
        private Job job;
        
         @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;
        
        public Long getId(){
            return id;
        }
        
        public String getEmail(){
            return email;
        }
        public void setEmail(String email){
            this.email = email;
        }
        public Job getJob(){
            return job;
        }
        public void setJob(Job job){
            this.job = job;
        }
        public User getUser(){
            return user;
        }
        public void setUser(User user){
            this.user = user;
        }
}
