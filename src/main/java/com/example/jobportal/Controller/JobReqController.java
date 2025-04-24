package com.example.jobportal.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.jobportal.Entities.JobRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class JobReqController {
    
    @PostMapping("/AddJobRequest")
    public ResponseEntity<JobRequest> Jobrequest(@RequestBody JobRequest entity) {
        
        return null;
    }
    
    @PutMapping("/UpdateJobStatus/{id}")
    public ResponseEntity<JobRequest> UpdateStatus(@PathVariable long id) {

        
        return null;
    }

    // @DeleteMapping("/DeleteJobApp")
}
