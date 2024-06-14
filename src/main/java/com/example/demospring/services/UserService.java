package com.example.demospring.services;

import com.example.demospring.dto.requests.UserCreateRequest;
import com.example.demospring.entities.User;
import com.example.demospring.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User saveOneUser(UserCreateRequest newUser) {
        User user = new User();
        user.setName(newUser.getName());
        user.setSurname(newUser.getSurname());
        user.setEmail(newUser.getEmail());
        user.setBirthdate(newUser.getBirthdate());
        user.setPassword(newUser.getPassword());
        return userRepository.save(user);
    }

    public int calculateAllLeaveDays(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if(user == null) {
            return -1;
        }
        return user.getLeaves().stream().mapToInt(leave -> leave.getLeaveDays()).sum();
    }

    public User getOneUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
        // how to get leaves too? //
    }
}
