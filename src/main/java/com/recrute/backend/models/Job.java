package com.recrute.backend.models;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Job implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @Column(name="jobName")
    @Size(max = 20)
    private String jobName;

    @Column(name="Company")
    @Size(max = 20)
    private String Company;

    @Column(name="location")
    @Size(max = 20)
    private String location;

    @Column(name="taken")
    @Size(max = 20)
    private Boolean taken;

    @Column(name="date")
    @JsonFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
    private Date date;

    

    public Job() {
    }

    public Job(Long id, String jobName, String Company, String location, Boolean taken, Date date) {
        this.id = id;
        this.jobName = jobName;
        this.Company = Company;
        this.location = location;
        this.taken = taken;
        this.date = date;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobName() {
        return this.jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getCompany() {
        return this.Company;
    }

    public void setCompany(String Company) {
        this.Company = Company;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean isTaken() {
        return this.taken;
    }

    public Boolean getTaken() {
        return this.taken;
    }

    public void setTaken(Boolean taken) {
        this.taken = taken;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Job id(Long id) {
        setId(id);
        return this;
    }

    public Job jobName(String jobName) {
        setJobName(jobName);
        return this;
    }

    public Job Company(String Company) {
        setCompany(Company);
        return this;
    }

    public Job location(String location) {
        setLocation(location);
        return this;
    }

    public Job taken(Boolean taken) {
        setTaken(taken);
        return this;
    }

    public Job date(Date date) {
        setDate(date);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Job)) {
            return false;
        }
        Job job = (Job) o;
        return Objects.equals(id, job.id) && Objects.equals(jobName, job.jobName) && Objects.equals(Company, job.Company) && Objects.equals(location, job.location) && Objects.equals(taken, job.taken) && Objects.equals(date, job.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, jobName, Company, location, taken, date);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", jobName='" + getJobName() + "'" +
            ", Company='" + getCompany() + "'" +
            ", location='" + getLocation() + "'" +
            ", taken='" + isTaken() + "'" +
            ", date='" + getDate() + "'" +
            "}";
    }

}
