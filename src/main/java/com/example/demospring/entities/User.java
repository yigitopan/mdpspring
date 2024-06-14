package com.example.demospring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String email;

    @Temporal(TemporalType.DATE)
    private Date birthdate;

    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Leave> leaves;
}
