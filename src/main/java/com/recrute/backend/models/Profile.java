package com.recrute.backend.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import javafx.scene.control.ListView.EditEvent;



@Entity
public class Profile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProfile;


   
    @Column(name = "skills")
    @Enumerated(EnumType.STRING)
    @Size(max = 300)
    private Skill skills;

    
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy="profile",cascade = CascadeType.PERSIST)
    List <Education> educations;
   

    @OneToMany(mappedBy="profile",cascade = CascadeType.PERSIST)
    List <Experience> experiences;

    @OneToOne(cascade = CascadeType.ALL,mappedBy="profile")
    Contact contact;



   


    public Profile() {

        
    }

    public Profile(Long idProfile, Skill skills, LocalDateTime createdAt,List<Experience> experiences) {
        this.idProfile = idProfile;
        this.skills = skills;
        this.createdAt = createdAt;
        this.experiences = experiences;
    }

    public Profile(Long idProfile, Skill skills, LocalDateTime createdAt, List<Education> educations, List<Experience> experiences, Contact contact) {
        this.idProfile = idProfile;
        this.skills = skills;
        this.createdAt = createdAt;
        this.educations = educations;
        this.experiences = experiences;
        this.contact = contact;
    }

    public Long getIdProfile() {
        return this.idProfile;
    }

    public void setIdProfile(Long idProfile) {
        this.idProfile = idProfile;
    }

    public Skill getSkills() {
        return this.skills;
    }

    public void setSkills(Skill skills) {
        this.skills = skills;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Education> getEducations() {
        return this.educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public List<Experience> getExperiences() {
        return this.experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    public Contact getContact() {
        return this.contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Profile idProfile(Long idProfile) {
        setIdProfile(idProfile);
        return this;
    }

    public Profile skills(Skill skills) {
        setSkills(skills);
        return this;
    }

    public Profile createdAt(LocalDateTime createdAt) {
        setCreatedAt(createdAt);
        return this;
    }

    public Profile educations(List<Education> educations) {
        setEducations(educations);
        return this;
    }

    public Profile experiences(List<Experience> experiences) {
        setExperiences(experiences);
        return this;
    }

    public Profile contact(Contact contact) {
        setContact(contact);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Profile)) {
            return false;
        }
        Profile profile = (Profile) o;
        return Objects.equals(idProfile, profile.idProfile) && Objects.equals(skills, profile.skills) && Objects.equals(createdAt, profile.createdAt) && Objects.equals(educations, profile.educations) && Objects.equals(experiences, profile.experiences) && Objects.equals(contact, profile.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProfile, skills, createdAt, educations, experiences, contact);
    }

    @Override
    public String toString() {
        return "{" +
            " idProfile='" + getIdProfile() + "'" +
            ", skills='" + getSkills() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", educations='" + getEducations() + "'" +
            ", experiences='" + getExperiences() + "'" +
            ", contact='" + getContact() + "'" +
            "}";
    }
    


    



   
   

    



    


   

    
   

}
