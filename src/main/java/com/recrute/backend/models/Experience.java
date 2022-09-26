package com.recrute.backend.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Experience implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idExp;

    
    @Column(name="workExp")
    @Size(max = 20)
    private String workExp;

    @Column(name="academicExp")
    @Size(max = 20)
    private String academicExp;

    @Column(name="started")
    @JsonFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
    private Date started;

    @Column(name="ended")
    @JsonFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
    private Date ended;

    @ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name = "id")
    // @JsonIgnoreProperties(value = {
    //     "experiences"
    // })
     Profile profilea;




    

    public Experience() {
    }
    public Experience( String workExp, String academicExp, Date started, Date ended, Profile profilea) {
        
        this.workExp = workExp;
        this.academicExp = academicExp;
        this.started = started;
        this.ended = ended;
        this.profilea = profilea;
    }

    public Experience(Long idExp, String workExp, String academicExp, Date started, Date ended, Profile profilea) {
        this.idExp = idExp;
        this.workExp = workExp;
        this.academicExp = academicExp;
        this.started = started;
        this.ended = ended;
        this.profilea = profilea;
    }

    public Long getIdExp() {
        return this.idExp;
    }

    public void setIdExp(Long idExp) {
        this.idExp = idExp;
    }

    public String getWorkExp() {
        return this.workExp;
    }

    public void setWorkExp(String workExp) {
        this.workExp = workExp;
    }

    public String getAcademicExp() {
        return this.academicExp;
    }

    public void setAcademicExp(String academicExp) {
        this.academicExp = academicExp;
    }

    public Date getStarted() {
        return this.started;
    }

    public void setStarted(Date started) {
        this.started = started;
    }

    public Date getEnded() {
        return this.ended;
    }

    public void setEnded(Date ended) {
        this.ended = ended;
    }

    public Profile getProfilea() {
        return this.profilea;
    }

    public void setProfilea(Profile profilea) {
        this.profilea = profilea;
    }

    public Experience idExp(Long idExp) {
        setIdExp(idExp);
        return this;
    }

    public Experience workExp(String workExp) {
        setWorkExp(workExp);
        return this;
    }

    public Experience academicExp(String academicExp) {
        setAcademicExp(academicExp);
        return this;
    }

    public Experience started(Date started) {
        setStarted(started);
        return this;
    }

    public Experience ended(Date ended) {
        setEnded(ended);
        return this;
    }

    public Experience profilea(Profile profilea) {
        setProfilea(profilea);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Experience)) {
            return false;
        }
        Experience experience = (Experience) o;
        return Objects.equals(idExp, experience.idExp) && Objects.equals(workExp, experience.workExp) && Objects.equals(academicExp, experience.academicExp) && Objects.equals(started, experience.started) && Objects.equals(ended, experience.ended) && Objects.equals(profilea, experience.profilea);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idExp, workExp, academicExp, started, ended, profilea);
    }

    @Override
    public String toString() {
        return "{" +
            " idExp='" + getIdExp() + "'" +
            ", workExp='" + getWorkExp() + "'" +
            ", academicExp='" + getAcademicExp() + "'" +
            ", started='" + getStarted() + "'" +
            ", ended='" + getEnded() + "'" +
            ", profilea='" + getProfilea() + "'" +
            "}";
    }
    
    
   


    
    
    
}
