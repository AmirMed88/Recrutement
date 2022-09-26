package com.recrute.backend.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Job implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "position")
    @Size(max = 20)
    private String position;

    @Column(name = "Company")
    @Size(max = 20)
    private String Company;

    @Column(name = "level")
    @Size(max = 20)
    private String level;

    @Column(name = "location")
    @Size(max = 20)
    private String location;

    @Column(name = "contract")
    @Size(max = 20)
    private String contract;

    @Column(name = "role")
    @Size(max = 20)
    private String role;

    @Column(name = "logo")
    @Size(max = 20)
    private String logo;

    @ElementCollection() // 1
    @CollectionTable(name = "languages") //
    @Column(name = "languages") // 3
    private List<String> languages;

    @ElementCollection() // 1
    @CollectionTable(name = "tools") //
    @Column(name = "tools") // 3
    private List<String> tools;

    @Column(name = "featured")
    private Boolean featured = false;

    @Column(name = "date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date postedAt;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;

    // @OneToMany(mappedBy="job")
    // @Size(max = 20)
    // private List<Tool> tools;

    // @OneToMany(mappedBy="joba")
    // @Size(max = 20)
    // private List<Language> languages;

}
