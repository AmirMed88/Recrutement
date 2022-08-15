package com.recrute.backend.Services;

import java.util.List;

import com.recrute.backend.models.Job;

public interface JobService {

    Job addJob(Job job);

    void updateJob(Job job);

    List<Job> retrieveAllJobs();

    void cancelJob(Long id);

    Job retrieveJob(Long id);

   
    void deleteJob(Long id);
}
