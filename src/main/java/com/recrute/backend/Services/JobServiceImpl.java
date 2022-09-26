package com.recrute.backend.Services;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.recrute.backend.models.Job;
// import com.recrute.backend.models.Language;
// import com.recrute.backend.models.Tool;
import com.recrute.backend.repositories.ContactRepository;
import com.recrute.backend.repositories.EducationRepository;
import com.recrute.backend.repositories.ExperienceRepository;
import com.recrute.backend.repositories.JobRepository;

import org.springframework.util.StringUtils;

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

        // ArrayList < Language > ls = new ArrayList<Language>();
        // ArrayList < Tool > ts = new ArrayList<Tool>();
        
        
        
        
        
        // Profile p=new Profile();

        // for(Language l:job.getLanguages()){
        //     ls.add(new Language(l.getId(),l.getName(), job));
           
           
        // }
        

        // for(Tool t:job.getTools()){
        //     ts.add(new Tool(t.getId(),t.getName(), job));
           
        // }
        
        
        
        // job.setLanguages(ls);
        // job.setTools(ts);
            jobRepository.save(job);
            return job;
    }


    // @Override
    // public Job addJob(MultipartFile file,Job job) {

    //     ArrayList < Language > ls = new ArrayList<Language>();
    //     ArrayList < Tool > ts = new ArrayList<Tool>();
        
        
        
        
        
    //     // Profile p=new Profile();

    //     for(Language l:job.getLanguages()){
    //         ls.add(new Language(l.getId(),l.getName(), job));
           
           
    //     }
        

    //     for(Tool t:job.getTools()){
    //         ts.add(new Tool(t.getId(),t.getName(), job));
           
    //     }
        
        
    //     ////////////////////////////////////////////////////////////////////////////
    //     String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	// 	if(fileName.contains(".."))
	// 	{
	// 		System.out.println("not a a valid file");
	// 	}
	// 	try {
	// 		job.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
	// 	} catch (IOException e) {
	// 		e.printStackTrace();
	// 	}
    //     job.setLanguages(ls);
    //     job.setTools(ts);
    //         jobRepository.save(job);
    //         return job;
    // }
    
    @Override
    public void updateJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
        
    }


    @Override
    public List<Job> retrieveJobByPosition(String position) {
        
        return jobRepository.retrieveJobByPosition(position);
    }

   

    


}
