package com.recrute.backend.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recrute.backend.models.Contact;
import com.recrute.backend.models.Profile;
import com.recrute.backend.repositories.ContactRepository;
import com.recrute.backend.repositories.EducationRepository;
import com.recrute.backend.repositories.ExperienceRepository;
import com.recrute.backend.repositories.ProfileRepository;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ExperienceRepository experienceRepository;
    @Autowired
    ProfileRepository profileRepository;


    @Autowired
    ContactRepository contactRepository;

    @Autowired
    EducationRepository educationRepository;


    @Override
    public List<Contact> retrieveAllContacts() {
        return contactRepository.findAll();
    }

  
    

    @Override
    public Contact retrieveContact(Long id) {
        return contactRepository.findById(id).get();
    }

    @Override
    public Contact addContact(Contact contact) {
        	
            contactRepository.save(contact);
            return contact;
    }
    
    @Override
    public void updateContact(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
        
    }
    @Override
    public Contact SaveContactWithProfile(Profile profile,Contact contact){
        
       
        contact.setProfileb(profile);
        profileRepository.save(profile);
        contactRepository.save(contact);
        
        
        
        return contact;

        
    }
    
}
