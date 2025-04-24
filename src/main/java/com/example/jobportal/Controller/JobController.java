package com.example.jobportal.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.jobportal.Entities.JobForm;
import com.example.jobportal.Service.JobService;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;

// import java.util.List;

// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;




@RestController
public class JobController {

    @Autowired
    private JobService job;


    @PostMapping("AddJob")
    public ResponseEntity<JobForm> Addjob(@RequestBody JobForm entity) {
        try{
            JobForm form = job.AddJob(entity);
            if(form == null){
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
            return new ResponseEntity<>(form,HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new RuntimeErrorException(null);
        }
        // return null;
    }
    

    
    @PutMapping("ModifyJob/{jobid}")
    public ResponseEntity<JobForm> Modifyjob(@PathVariable long jobid, @RequestBody JobForm entity) {
        try{
            JobForm NwForm = job.UpdateJob(jobid,entity);
            if(NwForm == null){
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }
            return new ResponseEntity<>(NwForm,HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new RuntimeErrorException(null);
        }
    }

    @PutMapping("Admin/ChangeJobStatus/{jobid}/{jobstatus}")
    public ResponseEntity<JobForm> JobStatus(@PathVariable long jobid,@PathVariable String jobstatus) {
        try{
            JobForm NwForm = job.ChangeStatus(jobid,jobstatus);
            if(NwForm == null){
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }
            return new ResponseEntity<>(NwForm,HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new RuntimeErrorException(null);
        }
    }

    @GetMapping("/GetJobs")
    public ResponseEntity<List<JobForm>> getAllJobs() {
        try{
            List<JobForm> alljob = job.getAllJobs();
            return new ResponseEntity<>(alljob,HttpStatus.OK);
        } catch (Exception e){
            throw new RuntimeErrorException(null);
        }
    }

    @DeleteMapping("/RemoveJob")
    public ResponseEntity<JobForm> DeleteJob(@PathVariable long jobid) {
        try{
            JobForm NwForm = job.RemoveJob(jobid);
            if(NwForm == null){
                return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
            }
            return new ResponseEntity<>(NwForm,HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new RuntimeErrorException(null);
        }
    }

}
