package com.recrute.backend.Services;

import java.util.List;

import com.recrute.backend.models.Experience;

public interface ExperienceService {

    List<Experience> addManyExperience(List<Experience> experiences);


    Experience CreateAndAffectExperienceToProfile(Experience experience,Long idProfile);
    void AssignExperienceToProfile(Long idProfile,Long idExperience);

    Experience addExperience(Experience experience);

    void updateExperience(Experience experience);

    List<Experience> retrieveAllExperiences();

    void cancelExperience(Long id);

    Experience retrieveExperience(Long id);

   
    void deleteExperience(Long id);
}
