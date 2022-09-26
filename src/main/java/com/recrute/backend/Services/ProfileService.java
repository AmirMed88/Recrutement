package com.recrute.backend.Services;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.recrute.backend.models.Contact;
import com.recrute.backend.models.Education;
import com.recrute.backend.models.Experience;
import com.recrute.backend.models.Profile;
import com.recrute.backend.models.Skill;

public interface ProfileService {

    
    List<Profile> retrieveAllProfiles();

    void cancelProfile(Long id);

    Profile retrieveProfile(Long id);

    Profile addProfile(Profile profile);

    void updateProfile(Profile profile);

    void deleteProfile(Long id);
    void ApproveProfile(Long id);
    
    public Profile SaveProfileWithContact(Profile profile,Contact contact);

    public Profile SaveSubmission(Profile profile,Contact contact,List<Experience> exps);
    public Profile SaveWithExperienceSubmission(Profile profile,List<Experience> exps);
    public Profile addSubmission(Profile profile,Contact contact,Set<Experience> experiences,Set<Education> educations);

    List<Profile> retrieveAllProfileByDateDesc();
    List<Profile> retrieveAllProfileByDateAsc();
    List<Profile> retrieveProfileByDate( Date date);
    
    List<Profile> retrieveAllProfileBySkill(String skill);
    
    
}
