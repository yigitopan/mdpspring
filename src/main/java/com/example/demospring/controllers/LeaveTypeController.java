package com.example.demospring.controllers;


import com.example.demospring.dto.requests.LeaveTypeCreateRequest;
import com.example.demospring.entities.LeaveType;
import com.example.demospring.services.LeaveTypeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leave-types")
public class LeaveTypeController {

    private LeaveTypeService leaveTypeService;

    public LeaveTypeController(LeaveTypeService leaveTypeService) {
        this.leaveTypeService = leaveTypeService;
    }

    @PostMapping
    public LeaveType addLeaveType(@RequestBody LeaveTypeCreateRequest leaveTypeCreateRequest) {
        return leaveTypeService.addLeaveType(leaveTypeCreateRequest);
    }


}
