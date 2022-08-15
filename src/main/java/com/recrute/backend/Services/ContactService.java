package com.recrute.backend.Services;

import java.util.List;

import com.recrute.backend.models.Contact;
import com.recrute.backend.models.Profile;

public interface ContactService {

    List<Contact> retrieveAllContacts();

    Contact retrieveContact(Long id);

    Contact addContact(Contact contact);

    void updateContact(Contact contact);

    void deleteContact(Long id);

    Contact SaveContactWithProfile(Profile profile,Contact contact);
    
    
}
