package com.recrute.backend.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.recrute.backend.models.Profile;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long>{
    List<Profile> findAll();

    

//     @Query("select f from Profile f where f.createdAt between :from and :to")
//     Set<Profile> retirveAllProfileBetweenDate(@Param("from") Date from, @Param("to") Date to);

//     @Query("SELECT f from Profile f order by f.createdAt desc ")
//     Set<Profile> retrieveAllProfileByDateProfileDesc();

//     @Query("select f from Profile f order by f.date")
//     Set<Profile> retrieveAllProfileByDateProfileAsc();

//     // @Query("select f from Profile f where f.idProfile = :idProfile")
//     // Profile retrieveProfileById(@Param("idProfile") Long idProfile);
       

//     @Query("select f from Profile f where f.createdAt = :date")
//    Set<Profile> retrieveAllProfileByDate(@Param("date") String date);
    
    
//     @Query("select f from Profile f where f.contact.idContact = :idContact")
//    Set<Profile> retrieveAllProfileByIdContact(@Param("idContact") Long idContact);
}

