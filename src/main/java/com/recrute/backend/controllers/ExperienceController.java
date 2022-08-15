package com.recrute.backend.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.recrute.backend.Services.ExperienceService;

import com.recrute.backend.models.Experience;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/experience")

public class ExperienceController {
    

    @Autowired
    ExperienceService experienceService;

    @PostMapping("/addExperience")
    public Experience addExperience (@RequestBody Experience experience){
        Experience f= experienceService.addExperience(experience);
        return f;
    }

    @PostMapping("/addExperiences")
    public List<Experience> addExperiences (@RequestBody List<Experience> experiences){
        List<Experience> result= experienceService.addManyExperience(experiences);
        return result;
    }

    @PostMapping("/CreateAffectExperiences/{idProfile}")
    public Experience CreateAffectExperiences (@RequestBody Experience experience,@PathVariable("idProfile") Long idProfile){
        Experience result= experienceService.CreateAndAffectExperienceToProfile(experience, idProfile);
        return result;
    }

    @PostMapping("/AssignExpToProfile/{idProfile}/{idExperience}")
    public void AssignExperienceToProfile (@PathVariable("idProfile") Long idProfile,@PathVariable("idExperience") Long idExperience){
        experienceService.AssignExperienceToProfile(idProfile, idExperience);
        
    }
    
    
    @GetMapping("getAllExperiences")
    public List<Experience> getAllExperiences(){
        return experienceService.retrieveAllExperiences();
    }
    
    @GetMapping("/getExperienceById/{id}")
    public Experience getExperienceById(@PathVariable("id") Long id){
        return experienceService.retrieveExperience(id);
    }
  
    

    @PutMapping("/updateExperience")
    public void updateExperience(@RequestBody Experience experience){
        experienceService.updateExperience(experience);
    }
    
    
 

   
    @DeleteMapping("/deleteExperience/{idExperience}")
    public void deleteExperience(@PathVariable("idExperience") Long idExperience){
        experienceService.deleteExperience(idExperience);
    }
    
    

    

   

}

  