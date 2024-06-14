package com.example.demospring.dto.requests;

import lombok.Data;

import java.util.Date;

@Data
public class UserCreateRequest {
    private String name;
    private String surname;
    private String email;
    private String password;
    private Date birthdate;
}
