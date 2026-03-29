package com.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jobportal.entity.Application;
import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
   
    List<Application> findByJob_Id(Long jobId);
} 
