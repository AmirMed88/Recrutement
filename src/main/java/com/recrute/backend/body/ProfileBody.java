package com.recrute.backend.body;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.recrute.backend.models.Contact;
import com.recrute.backend.models.Education;
import com.recrute.backend.models.Experience;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileBody {

    private List<String> skills;
    private Boolean approval;
    private String destination;
    private Date createdAt;
    private List<Education> educations;
    private List<Experience> experiences;
    private Contact contact;

}
