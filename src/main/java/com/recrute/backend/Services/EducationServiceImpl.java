package com.recrute.backend.Services;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recrute.backend.models.Education;
import com.recrute.backend.models.Profile;
import com.recrute.backend.repositories.ContactRepository;
import com.recrute.backend.repositories.EducationRepository;
import com.recrute.backend.repositories.ProfileRepository;
import com.recrute.backend.repositories.EducationRepository;
import com.recrute.backend.repositories.EducationRepository;

@Service
public class EducationServiceImpl implements EducationService {




    @Autowired
    ContactRepository contactRepository;

    @Autowired
    EducationRepository educationRepository;

    @Autowired
    ProfileRepository profileRepository;


    @Override
    public List<Education> retrieveAllEducations() {
        return educationRepository.findAll();
    }

  
    @Override
	public void cancelEducation(Long idEducation) {
	Education a = educationRepository.findById(idEducation).get();
	educationRepository.save(a);
		
		
	}

    @Override
    public Education retrieveEducation(Long id) {
        return educationRepository.findById(id).get();
    }

    @Override
    public Education addEducation(Education education) {
        	
            educationRepository.save(education);
            return education;
    }
    
    @Override
    public void updateEducation(Education education) {
        educationRepository.save(education);
    }

    @Override
    public void deleteEducation(Long id) {
        educationRepository.deleteById(id);
        
    }

    @Override
    public List<Education> addManyEducation(List<Education> educations) {
        	// List<Education> exprs=new ArrayList<Education>();
            // for(Education e:educations){
            //     educationRepository.save(e);
            // }
            educationRepository.saveAll(educations);
            return educations;
    }
    
    @Override
    public void AssignEducationToProfile(Long idProfile,Long idEducation){

        Profile prf=profileRepository.findById(idProfile).get();
        Education ex=educationRepository.findById(idEducation).get();
        ex.setProfile(prf);
        educationRepository.save(ex);
        
        
    }

   

    


}
