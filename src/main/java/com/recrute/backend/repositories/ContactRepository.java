package com.recrute.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.recrute.backend.models.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact,Long> {
    List<Contact> findAll();
}
