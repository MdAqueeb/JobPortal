package com.example.jobportal.Repository;

// import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jobportal.Entities.JobForm;

@Repository
public interface JobRepo extends JpaRepository<JobForm,Long> {
    
}
