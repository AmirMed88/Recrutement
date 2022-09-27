package com.recrute.backend.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.recrute.backend.Services.EmailSenderService;
import com.recrute.backend.Services.ProfileService;
import com.recrute.backend.body.ProfileBody;
import com.recrute.backend.models.Contact;
import com.recrute.backend.models.Education;
import com.recrute.backend.models.Experience;
import com.recrute.backend.models.Profile;
import com.recrute.backend.models.Skill;
import com.recrute.backend.repositories.ProfileRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/profile")

public class ProfileController {

    @Autowired
    ProfileService profileService;
    @Autowired
    private EmailSenderService senderService;

    @Autowired
    ProfileRepository profileRepository;

    // http://localhost:8081/api/submission/getAllProfiles
    @GetMapping("getAllProfiles")
    public List<Profile> getAllProfiles() {
        return profileService.retrieveAllProfiles();
    }

    @GetMapping("getProfileById/{id}")
    public Profile getProfileById(@PathVariable("id") Long id) {
        return profileService.retrieveProfile(id);
    }

    @PostMapping("sendMail")
    public void triggerMail(@RequestParam String email) throws MessagingException {
        // public void triggerMail( @RequestBody String email ) throws
        // MessagingException {
        senderService.sendSimpleEmail(email,
                "Interview",
                "Are you interested i joining our company");
                

    }

    // @PatchMapping("/updateProfile/{id}")
    // public void updateProfile(@RequestBody Profile profile, @PathVariable("id") Long id) {
    //     profileService.updateProfile(profile,id);
    // }
    @PatchMapping("/updateProfile/{id}")
    public void updateProfile(@RequestBody Profile profile) {
        profileService.updateProfile(profile);
    }
    @PutMapping("/approveprofile/{id}")
    public void updateProfile(@PathVariable("id") Long id) {
        profileService.ApproveProfile(id);
    }

    @DeleteMapping("/deleteProfile/{idProfile}")
    public void deleteProfile(@PathVariable("idProfile") Long idProfile) {
        profileService.deleteProfile(idProfile);
    }

    @PostMapping("/addProfile")
    public ResponseEntity<?> addProfile(@RequestBody ProfileBody profile) {

        List<Skill> skills = new ArrayList<>();
        Profile pr = new Profile(skills, profile.getApproval(), profile.getDestination(), profile.getCreatedAt(),
                profile.getEducations(), profile.getExperiences(), profile.getContact());

        List<String> strSkills = profile.getSkills();

        if (strSkills == null) {
            return ResponseEntity
                    .badRequest()
                    .body(("Error: error!"));

        } else {
            strSkills.forEach(skill -> {
                switch (skill) {
                    case "ANGULAR":
                        skills.add(Skill.ANGULAR);

                        break;
                    case "EXPRESSJS":

                        skills.add(Skill.EXPRESSJS);

                        break;

                    case "NODEJS":

                        skills.add(Skill.NODEJS);

                        break;

                    case "REACTJS":

                        skills.add(Skill.REACTJS);

                        break;

                    case "SPRINGBOOT":

                        skills.add(Skill.SPRINGBOOT);

                        break;

                    case "PYTHON":

                        skills.add(Skill.PYTHON);

                        break;
                    default:

                        skills.add(Skill.JAVA);
                }
            });
        }

        pr.setSkill(skills);
       profileService.addProfile(pr);
        return ResponseEntity.ok(("added profile!"));
    }

    // // @PostMapping("add/addsubmission")
    // // public Profile addSubmissions (@RequestBody Profile p, Contact c,
    // Set<Education> eds,Set<Experience> exps){
    // // Profile f= profileService.addSubmission(p, c, exps, eds);
    // // return f;
    // // }
    // // @PostMapping("/add/saveSub")
    // // public Profile saveSubmissions (@RequestBody Profile p, Contact
    // c,List<Experience> exps){
    // // Profile f= profileService.SaveSubmission(p, c,exps);
    // // return f;
    // // }

    // @PostMapping("/add/withexpSub")
    // public Profile saveSubmissions (@RequestBody Profile p,List<Experience>
    // exps){
    // Profile f= profileService.SaveWithExperienceSubmission(p, exps);
    // return f;
    // }

    @PostMapping("/CreateProfileWithContact")
    public Profile addProfileWithContact(@RequestBody Profile profile, Contact contact) {

        Profile f = profileService.SaveProfileWithContact(profile, contact);
        return f;
    }

    @GetMapping("/getProfileBySkills/{skill}")
    public List<Profile> getProfileBySkills(@PathVariable("skill") String skill) {

        return profileService.retrieveAllProfileBySkill(skill);
    }

    @GetMapping("/getProfileDesc")
    public List<Profile> getProfileByDateDesc() {

        return profileService.retrieveAllProfileByDateDesc();
    }

    @GetMapping("/getProfileAsc")
    public List<Profile> getProfileByDateAsc() {

        return profileService.retrieveAllProfileByDateAsc();
    }

    @GetMapping("/getProfileByDate/{date}")
    public List<Profile> getProfileByDate(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {

        return profileService.retrieveProfileByDate(date);
    }

}
