package com.recrute.backend.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Uinfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @Size(max = 300)
    private String name;

    @Column(name = "surname")
    @Size(max = 300)
    private String surname;

    @Column(name = "mail")
    @Size(max = 300)
    private String mail;

    @Column(name = "age")
    @Size(max = 300)
    private String age;

    @Column(name = "admin")
    @Size(max = 300)
    private Boolean admin=false;

    @Column(name = "working")
    @Size(max = 300)
    private boolean working=false;

    @OneToOne(mappedBy="uinfo")
    @JsonIgnoreProperties(value = {
        "uinfo"
})
    User user;

    


    public Uinfo(String name, String surname, String mail, String age, boolean working, User user) {
       
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.age = age;
        this.working = working;
        this.user = user;
    }


    // @ManyToOne()
    // private Job job;
    
}
