package com.example.jobportal.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userid;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false,unique = true)
    private String phoneno;

    @Column(columnDefinition = "LONGTEXT")
    private String avatar;

    @Column(nullable = false)
    private String password;

    public enum Role {
        USER,EMPLOYEE,ADMIN
    }

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    private List<JobRequest> jobreq;

}
