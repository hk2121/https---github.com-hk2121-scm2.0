package com.scm.scm20.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Contact {

    @Id
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String picture;
    @Column(length = 10000)
    private String description;
    private boolean favorite = false;

    private String websiteLink;
    private String linkedInLink;
    // private List<SocialLink> socialLink = new ArrayList<>();

}
