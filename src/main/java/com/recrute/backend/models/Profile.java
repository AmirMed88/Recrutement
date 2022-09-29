package com.recrute.backend.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProfile;

    @ElementCollection(targetClass = Skill.class)
    @JoinTable(name = "person_skill", joinColumns = @JoinColumn(name = "idProfile"))
    @Column(name = "skills", nullable = false)
    @Enumerated(EnumType.STRING)
    private List<Skill> skill;

    @Column(name = "approved")
    private Boolean approval = false;

    @Column(name = "destination")
    @Size(max = 300)
    private String destination;

    @Column(updatable = false)
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = {
            "profile"
    })
    List<Education> educations;

    @OneToMany(mappedBy = "profilea", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = {
            "profilea"
    })
    List<Experience> experiences;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "profileb")
    @JsonIgnoreProperties(value = {
            "profileb"
    })
    Contact contact;

    @OneToOne(mappedBy = "profilec", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = {
        "profilec"
})
    Attachment attachment;
    // public Profile(Long idProfile, List<Skill> skill, Date
    // createdAt,List<Experience> experiences) {
    // this.idProfile = idProfile;
    // this.skill = skill;
    // this.createdAt = createdAt;
    // this.experiences = experiences;
    // }


    public Profile( List<Skill> skill, Boolean approval, String destination, Date createdAt, List<Education> educations, List<Experience> experiences, Contact contact) {
        
        this.skill = skill;
        this.approval = approval;
        this.destination = destination;
        this.createdAt = createdAt;
        this.educations = educations;
        this.experiences = experiences;
        this.contact = contact;
    }


        // public Profile(List<Skill> skill, Boolean approval, String destination, Date createdAt, List<Education> educations, List<Experience> experiences, Contact contact, Attachment attachment) {
                
        //         this.skill = skill;
        //         this.approval = approval;
        //         this.destination = destination;
        //         this.createdAt = createdAt;
        //         this.educations = educations;
        //         this.experiences = experiences;
        //         this.contact = contact;
        //         this.attachment = attachment;
        // }



}
