package com.recrute.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.recrute.backend.models.Education;
@Repository


public interface EducationRepository extends CrudRepository<Education,Long> {
    List<Education> findAll();
}
