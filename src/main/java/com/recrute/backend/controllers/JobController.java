package com.recrute.backend.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.recrute.backend.Services.JobService;

import com.recrute.backend.models.Job;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/job")

public class JobController {
    

    @Autowired
    JobService jobService;

    @PostMapping("/addJob")
    public Job addJob (@RequestBody Job job){
        Job f= jobService.addJob(job);
        return f;
    }

    
    
    @GetMapping("getAllJobs")
    public List<Job> getAllJobs(){
        return jobService.retrieveAllJobs();
    }
    
  
    

    @PutMapping("/updateJob")
    public void updateJob(@RequestBody Job job){
        jobService.updateJob(job);
    }
    
    
 
    @GetMapping("/getJobById/{id}")
    public Job getExperienceById(@PathVariable("id") Long id){
        return jobService.retrieveJob(id);
    }
   
    @DeleteMapping("/deleteJob/{idJob}")
    public void deleteJob(@PathVariable("idJob") Long idJob){
        jobService.deleteJob(idJob);
    }
    
    

    

   

}

  