package com.recrute.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.recrute.backend.models.Job;
@Repository
public interface JobRepository extends CrudRepository<Job,Long> {
    List<Job> findAll();

    @Query("select f from Job f where f.position LIKE %:position%")
    List<Job> retrieveJobByPosition(@Param("position") String position);
}
