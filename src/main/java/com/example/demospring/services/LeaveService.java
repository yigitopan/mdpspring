package com.example.demospring.services;

import com.example.demospring.dto.requests.LeaveCreateRequest;
import com.example.demospring.entities.Leave;
import com.example.demospring.entities.LeaveType;
import com.example.demospring.entities.User;
import com.example.demospring.repositories.LeaveRepository;
import com.example.demospring.repositories.LeaveTypeRepository;
import com.example.demospring.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class LeaveService {
    private LeaveRepository leaveRepository;
    private LeaveTypeRepository leaveTypeRepository;
    private UserRepository userRepository;

    public LeaveService(LeaveRepository leaveRepository, LeaveTypeRepository leaveTypeRepository, UserRepository userRepository) {
        this.leaveRepository = leaveRepository;
        this.leaveTypeRepository = leaveTypeRepository;
        this.userRepository = userRepository;
    }

    public Leave createLeave(LeaveCreateRequest leaveCreateRequest) {
        Leave leave = new Leave();
        leave.setStartDate(leaveCreateRequest.getStartDate());
        leave.setEndDate(leaveCreateRequest.getEndDate());

        System.out.println("leaveCreateRequest.getUserId() = " + leaveCreateRequest.getUserId());
        User user = userRepository.findById(leaveCreateRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        LeaveType leaveType = leaveTypeRepository.findById(leaveCreateRequest.getLeaveTypeId())
                .orElseThrow(() -> new RuntimeException("LeaveType not found"));

        leave.setUser(user);
        leave.setLeaveType(leaveType);
        return leaveRepository.save(leave);
    }
}
