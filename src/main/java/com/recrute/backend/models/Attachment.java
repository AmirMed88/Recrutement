package com.recrute.backend.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attachment implements Serializable {
    @Id
    @GeneratedValue(generator  ="uuid")
    @GenericGenerator(name="uuid", strategy ="uuid2")
    private String id;
    private String fileName;
    private String fileType;
    @Lob
    private byte[] data;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = {
            "attachment"
    })
    Profile profilec ;




   
 

    // public Attachment(String fileName, String fileType, byte[] data) {
        
    //     this.fileName = fileName;
    //     this.fileType = fileType;
    //     this.data = data;
    // }


    public Attachment(String fileName, String fileType, byte[] data, Profile profilec) {
        
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
        this.profilec = profilec;
    }

    
}

   

