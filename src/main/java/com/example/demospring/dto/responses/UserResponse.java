package com.example.demospring.dto.responses;

import com.example.demospring.entities.User;
import lombok.Data;

import java.util.Date;

@Data
public class UserResponse {
    private String fullName;
    private String email;
    private Date birthdate;

    public UserResponse(User user) {
        this.fullName = user.getName() + " " + user.getSurname();
        this.email = user.getEmail();
        this.birthdate = user.getBirthdate();
    }
}
