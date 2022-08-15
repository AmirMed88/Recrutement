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

import com.recrute.backend.Services.EducationService;

import com.recrute.backend.models.Education;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/education")

public class EducationController {
    

    @Autowired
    EducationService educationService;

    @PostMapping("/addEducation")
    public Education addEducation (@RequestBody Education education){
        Education f= educationService.addEducation(education);
        return f;
    }

    
    
    @GetMapping("getAllEducations")
    public List<Education> getAllEducations(){
        return educationService.retrieveAllEducations();
    }
    
  
    

    @PutMapping("/updateEducation")
    public void updateEducation(@RequestBody Education education){
        educationService.updateEducation(education);
    }
    
    
 

   
    @DeleteMapping("/deleteEducation/{idEducation}")
    public void deleteEducation(@PathVariable("idEducation") Long idEducation){
        educationService.deleteEducation(idEducation);
    }
    
    
    @GetMapping("/getEducationById/{id}")
    public Education getEducationById(@PathVariable("id") Long id){
        return educationService.retrieveEducation(id);
    }

    @PostMapping("/addEducations")
    public List<Education> addEducations (@RequestBody List<Education> educations){
        List<Education> result= educationService.addManyEducation(educations);
        return result;
    }

    @PostMapping("/AssignExpToProfile/{idProfile}/{idEducation}")
    public void AssignEducationToProfile (@PathVariable("idProfile") Long idProfile,@PathVariable("idEducation") Long idEducation){
        educationService.AssignEducationToProfile(idProfile, idEducation);
        
    }
    

   

}

  