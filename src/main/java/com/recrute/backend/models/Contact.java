package com.recrute.backend.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Contact implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idContact;

    @Column(name="fullname")
    @Size(max = 20)
    private String fullname;

    @Column(name="address")
    @Size(max = 120)
    private String address;

    
    @Column(name="email")
    @Size(max = 120)
    private String email;

    @Column(name="phone")
    @Size(max = 120)
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    Profile profile;



    
    

    public Contact() {
    }

    public Contact(Long idContact, String fullname, String address, String email, String phone, Profile profile) {
        this.idContact = idContact;
        this.fullname = fullname;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.profile = profile;
    }

    public Long getIdContact() {
        return this.idContact;
    }

    public void setIdContact(Long idContact) {
        this.idContact = idContact;
    }

    public String getFullname() {
        return this.fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Profile getProfile() {
        return this.profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Contact idContact(Long idContact) {
        setIdContact(idContact);
        return this;
    }

    public Contact fullname(String fullname) {
        setFullname(fullname);
        return this;
    }

    public Contact address(String address) {
        setAddress(address);
        return this;
    }

    public Contact email(String email) {
        setEmail(email);
        return this;
    }

    public Contact phone(String phone) {
        setPhone(phone);
        return this;
    }

    public Contact profile(Profile profile) {
        setProfile(profile);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Contact)) {
            return false;
        }
        Contact contact = (Contact) o;
        return Objects.equals(idContact, contact.idContact) && Objects.equals(fullname, contact.fullname) && Objects.equals(address, contact.address) && Objects.equals(email, contact.email) && Objects.equals(phone, contact.phone) && Objects.equals(profile, contact.profile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idContact, fullname, address, email, phone, profile);
    }

    @Override
    public String toString() {
        return "{" +
            " idContact='" + getIdContact() + "'" +
            ", fullname='" + getFullname() + "'" +
            ", address='" + getAddress() + "'" +
            ", email='" + getEmail() + "'" +
            ", phone='" + getPhone() + "'" +
            ", profile='" + getProfile() + "'" +
            "}";
    }

    

}
