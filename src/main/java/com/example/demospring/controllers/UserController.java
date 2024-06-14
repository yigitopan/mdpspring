package com.example.demospring.controllers;

import com.example.demospring.dto.requests.UserCreateRequest;
import com.example.demospring.dto.responses.UserResponse;
import com.example.demospring.entities.User;
import com.example.demospring.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody UserCreateRequest newUser) {
        User user = userService.saveOneUser(newUser);
        return ResponseEntity.ok(new UserResponse(user));
    }

    /*make this method return a list of UserResponse objects

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    *
     */

    @GetMapping("/{userId}")
    public UserResponse getUserById(@PathVariable Long userId) {
        User user = userService.getOneUser(userId);
        return new UserResponse(user);
    }

    @GetMapping("/days/{userId}")
    public int calculateAllLeaveDays(@PathVariable Long userId) {
        return userService.calculateAllLeaveDays(userId);
    }


}
