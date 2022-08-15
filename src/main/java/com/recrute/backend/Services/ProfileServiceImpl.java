package com.recrute.backend.Services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.recrute.backend.models.Contact;
import com.recrute.backend.models.Education;
import com.recrute.backend.models.Experience;
import com.recrute.backend.models.Profile;
import com.recrute.backend.repositories.ContactRepository;
import com.recrute.backend.repositories.EducationRepository;
import com.recrute.backend.repositories.ExperienceRepository;
import com.recrute.backend.repositories.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService {


    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    EducationRepository educationRepository;

    @Autowired
    ExperienceRepository experienceRepository;

    public Profile SaveProfileWithContact(Profile profile,Contact contact){
        
       
        profile.setContact(contact);
        
        contactRepository.save(contact);
        profileRepository.save(profile);
        
        
        return profile;

        
    }


    @Override
    @Transactional
    public Profile SaveSubmission(Profile profile,Contact contact,List<Experience> experiences){
        
        List<Experience> exps= new ArrayList<Experience>();;
            
             
            for(Experience ex: experiences){
               Experience e=experienceRepository.save(ex);
               exps.add(ex);
            }    
            


           Contact c = contactRepository.save(contact);
            
            profile.setExperiences(exps);
            profile.setContact(c);
            profileRepository.save(profile);
            
            
            return profile;
            
        
    }
    @Override
    @Transactional
    public Profile SaveWithExperienceSubmission(Profile profile,List<Experience> exps){

        
        // for(Experience e:exps){
        //     List<Experience> explist =new ArrayList<Experience>();
        //     experienceRepository.save(e);
        //     explist.add(e);
        // }
        experienceRepository.saveAll(exps);
        // profile.setExperiences(exps);
        profileRepository.save(profile);

        return profile;
    }


    @Override
    public List<Profile> retrieveAllProfiles() {
        return profileRepository.findAll();
    }

  
    @Override
	public void cancelProfile(Long idProfile) {
	Profile a = profileRepository.findById(idProfile).get();
	profileRepository.save(a);
		
		
	}

    @Override
    public Profile retrieveProfile(Long id) {
        return profileRepository.findById(id).get();
    }

    @Override
    public Profile addProfile(Profile profile) {
        	
            profileRepository.save(profile);
            return profile;
    }
    
    @Override
    public void updateProfile(Profile profile) {
        profileRepository.save(profile);
    }

    @Override
    public void deleteProfile(Long id) {
        profileRepository.deleteById(id);
        
    }

    @Override
    @Transactional
    public Profile addSubmission(Profile profile,Contact contact,Set<Experience> experiences,Set<Education> educations){
        
            
            List<Experience> exps= new ArrayList<Experience>();
            List<Education> eds= new ArrayList<Education>();
             
            for(Experience ex: experiences){
               experienceRepository.save(ex);
               exps.add(ex);
            }

            
            for(Education ed: educations){
               educationRepository.save(ed);
               eds.add(ed);
            }
            
            profile.setExperiences(exps);
            profile.setEducations(eds);
            profile.setContact(contact);
            contactRepository.save(contact);
            profileRepository.save(profile);
            
            
            return profile;
            
        
    }

    


}
