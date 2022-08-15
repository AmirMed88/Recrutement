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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.recrute.backend.Services.ProfileService;
import com.recrute.backend.models.Contact;
import com.recrute.backend.models.Education;
import com.recrute.backend.models.Experience;
import com.recrute.backend.models.Profile;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/profile")

public class ProfileController {
    

    @Autowired
    ProfileService profileService;

    //http://localhost:8081/api/submission/getAllProfiles
    @GetMapping("getAllProfiles")
    public List<Profile> getAllProfiles(){
        return profileService.retrieveAllProfiles();
    }
    
    @GetMapping("getProfileById")
    public Profile getProfileById(@PathVariable("id") Long id){
        return profileService.retrieveProfile(id);
    }
    
  
    

    @PutMapping("/updateProfile")
    public void updateProfile(@RequestBody Profile profile){
        profileService.updateProfile(profile);
    }
    
    
 

   
    @DeleteMapping("/deleteProfile/{idProfile}")
    public void deleteProfile(@PathVariable("idProfile") Long idProfile){
        profileService.deleteProfile(idProfile);
    }
    
    

    @PostMapping("/addProfile")
    public Profile addProfile (@RequestBody Profile profile){
        Profile f= profileService.addProfile(profile);
        return f;
    }

    // // @PostMapping("add/addsubmission")
    // // public Profile addSubmissions (@RequestBody Profile p, Contact c, Set<Education> eds,Set<Experience> exps){
    // //     Profile f= profileService.addSubmission(p, c, exps, eds);
    // //     return f;
    // // }
    // // @PostMapping("/add/saveSub")
    // // public Profile saveSubmissions (@RequestBody Profile p, Contact c,List<Experience> exps){
    // //     Profile f= profileService.SaveSubmission(p, c,exps);
    // //     return f;
    // // }

    // @PostMapping("/add/withexpSub")
    // public Profile saveSubmissions (@RequestBody Profile p,List<Experience> exps){
    //     Profile f= profileService.SaveWithExperienceSubmission(p, exps);
    //     return f;
    // }

    @PostMapping("/CreateProfileWithContact")
    public Profile addProfileWithContact (@RequestBody Profile profile,Contact contact){
        Profile f= profileService.SaveProfileWithContact(profile, contact);
        return f;
    }


}

  