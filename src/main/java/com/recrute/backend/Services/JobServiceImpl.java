package com.recrute.backend.Services;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recrute.backend.models.Job;
import com.recrute.backend.repositories.ContactRepository;
import com.recrute.backend.repositories.EducationRepository;
import com.recrute.backend.repositories.ExperienceRepository;
import com.recrute.backend.repositories.JobRepository;

@Service
public class JobServiceImpl implements JobService {


    @Autowired
    JobRepository jobRepository;

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    EducationRepository educationRepository;

    @Autowired
    ExperienceRepository experienceRepository;


    @Override
    public List<Job> retrieveAllJobs() {
        return jobRepository.findAll();
    }

  
    @Override
	public void cancelJob(Long idJob) {
	Job a = jobRepository.findById(idJob).get();
	jobRepository.save(a);
		
		
	}

    @Override
    public Job retrieveJob(Long id) {
        return jobRepository.findById(id).get();
    }

    @Override
    public Job addJob(Job job) {
        	
            jobRepository.save(job);
            return job;
    }
    
    @Override
    public void updateJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
        
    }

   

    


}
