package com.recrute.backend.controllers;

import java.util.List;

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

import com.recrute.backend.Services.ContactService;
import com.recrute.backend.models.Contact;
import com.recrute.backend.models.Profile;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/Contact")

public class ContactController {
    

    @Autowired
    ContactService contactService;

    //http://localhost:8081/api/submission/getAllContacts
    @GetMapping("getAllContacts")
    public List<Contact> getAllContacts(){
        return contactService.retrieveAllContacts();
    }
    
    @PostMapping("/CreateContactWithProfile")
    public Contact addProfileWithContact (@RequestBody Profile profile, Contact contact){
        Contact f= contactService.SaveContactWithProfile(profile, contact);
        return f;
    }
    

    @PutMapping("/updateContact")
    public void updateContact(@RequestBody Contact contact){
        contactService.updateContact(contact);
    }
    
    
 


    @DeleteMapping("/deleteContact/{idContact}")
    public void deleteContact(@PathVariable("idContact") Long idContact){
        contactService.deleteContact(idContact);
    }
    
    

    @PostMapping("/addContact")
    public Contact addContact (@RequestBody Contact contact){
        Contact f= contactService.addContact(contact);
        return f;
    }

}

  