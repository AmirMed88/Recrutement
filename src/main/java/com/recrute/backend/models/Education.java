package com.recrute.backend.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class Education implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEducation;

    
    @JsonFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
    @Column(name="Date")
    private Date Edate;


    @Column(name="content")
    @Size(max = 20)
    private String content;

    @Column(name="achievement")
    @Size(max = 20)
    private String achievement;

    
    @ManyToOne(fetch = FetchType.EAGER)
     Profile profile;





   
    


    public Education() {
    }

    public Education(Long idEducation, Date Edate, String content, String achievement, Profile profile) {
        this.idEducation = idEducation;
        this.Edate = Edate;
        this.content = content;
        this.achievement = achievement;
        this.profile = profile;
    }

    public Long getIdEducation() {
        return this.idEducation;
    }

    public void setIdEducation(Long idEducation) {
        this.idEducation = idEducation;
    }

    public Date getEdate() {
        return this.Edate;
    }

    public void setEdate(Date Edate) {
        this.Edate = Edate;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAchievement() {
        return this.achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    public Profile getProfile() {
        return this.profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Education idEducation(Long idEducation) {
        setIdEducation(idEducation);
        return this;
    }

    public Education Edate(Date Edate) {
        setEdate(Edate);
        return this;
    }

    public Education content(String content) {
        setContent(content);
        return this;
    }

    public Education achievement(String achievement) {
        setAchievement(achievement);
        return this;
    }

    public Education profile(Profile profile) {
        setProfile(profile);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Education)) {
            return false;
        }
        Education education = (Education) o;
        return Objects.equals(idEducation, education.idEducation) && Objects.equals(Edate, education.Edate) && Objects.equals(content, education.content) && Objects.equals(achievement, education.achievement) && Objects.equals(profile, education.profile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEducation, Edate, content, achievement, profile);
    }

    @Override
    public String toString() {
        return "{" +
            " idEducation='" + getIdEducation() + "'" +
            ", Edate='" + getEdate() + "'" +
            ", content='" + getContent() + "'" +
            ", achievement='" + getAchievement() + "'" +
            ", profile='" + getProfile() + "'" +
            "}";
    }

    



   
    
    

    

    
    

}
