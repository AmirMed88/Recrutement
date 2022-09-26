package com.recrute.backend.Services;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recrute.backend.models.Experience;
import com.recrute.backend.models.Profile;
import com.recrute.backend.repositories.ContactRepository;
import com.recrute.backend.repositories.EducationRepository;
import com.recrute.backend.repositories.ExperienceRepository;
import com.recrute.backend.repositories.ProfileRepository;
import com.recrute.backend.repositories.ExperienceRepository;

@Service
public class ExperienceServiceImpl implements ExperienceService {


    @Autowired
    ExperienceRepository experienceRepository;
    @Autowired
    ProfileRepository profileRepository;


    @Autowired
    ContactRepository contactRepository;

    @Autowired
    EducationRepository educationRepository;


    @Override
    public List<Experience> addManyExperience(List<Experience> experiences) {
        	List<Experience> exprs=new ArrayList<Experience>();
            for(Experience e:experiences){
                experienceRepository.save(e);
            }
            experienceRepository.saveAll(experiences);
            return experiences;
    }
    @Transactional
    @Override
    public Experience CreateAndAffectExperienceToProfile(Experience experience,Long idProfile){

        Profile prf=profileRepository.findById(idProfile).get();
        experience.setProfilea(prf);
        experienceRepository.save(experience);
        
        return experience;
    }
    @Override
    public void AssignExperienceToProfile(Long idProfile,Long idExperience){

        Profile prf=profileRepository.findById(idProfile).get();

        Experience ex=experienceRepository.findById(idExperience).get();
        ex.setProfilea(prf);
        profileRepository.save(prf);
        experienceRepository.save(ex);
        
        
    }


    @Override
    public List<Experience> retrieveAllExperiences() {
        return experienceRepository.findAll();
    }

  
    @Override
	public void cancelExperience(Long idExperience) {
	Experience a = experienceRepository.findById(idExperience).get();
	experienceRepository.save(a);
		
		
	}

    @Override
    public Experience retrieveExperience(Long id) {
        return experienceRepository.findById(id).get();
    }

    @Override
    public Experience addExperience(Experience experience) {
        	
            experienceRepository.save(experience);
            return experience;
    }
    
    @Override
    public void updateExperience(Experience experience) {
        experienceRepository.save(experience);
    }

    @Override
    public void deleteExperience(Long id) {
        experienceRepository.deleteById(id);
        
    }

   

    


}
