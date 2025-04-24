package com.example.jobportal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jobportal.Entities.JobRequest;

@Repository
public interface JobRequestRepo extends JpaRepository<Long,JobRequest> {
    
}
