package com.example.demospring.controllers;

import com.example.demospring.dto.requests.LeaveCreateRequest;
import com.example.demospring.entities.Leave;
import com.example.demospring.services.LeaveService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leaves")
public class LeaveController {

    private LeaveService leaveService;

    public LeaveController(LeaveService leaveService) {
        this.leaveService = leaveService;
    }

    @PostMapping
    public ResponseEntity<Leave> createLeave(@RequestBody LeaveCreateRequest leaveCreateRequest) {
       try {
           Leave newLeave = leaveService.createLeave(leaveCreateRequest);
           return new ResponseEntity<>(newLeave, HttpStatus.CREATED);
       } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
    }
}
