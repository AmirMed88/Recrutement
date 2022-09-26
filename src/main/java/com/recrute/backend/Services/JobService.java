package com.recrute.backend.Services;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.web.multipart.MultipartFile;

import com.recrute.backend.models.Job;

public interface JobService {

    Job addJob(Job job);

    void updateJob(Job job);

    List<Job> retrieveAllJobs();

    void cancelJob(Long id);

    Job retrieveJob(Long id);

   
    void deleteJob(Long id);
    List<Job> retrieveJobByPosition(String position);

}
