package com.recrute.backend.repositories;



import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.recrute.backend.models.Profile;
import com.recrute.backend.models.Skill;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long>{
    List<Profile> findAll();

    

    // @Query("select f from Profile f where f.createdAt between :from and :to")
    // List<Profile> retirveAllProfileBetweenDate(@Param("from") Date from, @Param("to") Date to);
    
    @Query("SELECT f from Profile f order by f.createdAt desc ")
     List<Profile> ProfileByDateDesc();

    @Query("select f from Profile f order by f.createdAt asc")
    List<Profile> ProfileByDateProfileAsc();

    @Query("select f from Profile f where f.createdAt=:date")
    List<Profile> retrieveProfileByDate(@Param("date") Date date);

    // @Query("select f from Profile f JOIN person_skill s ON f.idProfile=:s.idProfile where s.skills=:skill  ")
    @Query(value = "select * from Profile p where p.id_profile IN (select f1.id_profile from Profile f1 JOIN person_skill s ON f1.id_profile=s.id_profile where s.skills=:skill) " ,
    nativeQuery = true)
    List<Profile> retrieveProfileBySkill(@Param("skill") String skill);

   

 

       
    
    @Query("select f from Profile f where f.contact.idContact = :idContact")
   List<Profile> retrieveAllProfileByIdContact(@Param("idContact") Long idContact);
}

