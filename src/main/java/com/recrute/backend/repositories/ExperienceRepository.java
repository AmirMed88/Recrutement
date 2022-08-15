package com.recrute.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.recrute.backend.models.Experience;
@Repository
public interface ExperienceRepository extends CrudRepository<Experience,Long> {

    List<Experience> findAll();
    
}
