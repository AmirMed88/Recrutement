package com.recrute.backend.Services;

import java.util.List;

import com.recrute.backend.models.Education;

public interface EducationService {

    Education addEducation(Education education);

    void updateEducation(Education education);

    List<Education> retrieveAllEducations();

    void cancelEducation(Long id);

    Education retrieveEducation(Long id);

   
    void deleteEducation(Long id);
    List<Education> addManyEducation(List<Education> educations);


    
    void AssignEducationToProfile(Long idProfile,Long idEducation);
}
