package com.example.demospring.services;


import com.example.demospring.dto.requests.LeaveTypeCreateRequest;
import com.example.demospring.entities.LeaveType;
import com.example.demospring.repositories.LeaveTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class LeaveTypeService {

    private LeaveTypeRepository leaveTypeRepository;

    public LeaveTypeService(LeaveTypeRepository leaveTypeRepository) {
        this.leaveTypeRepository = leaveTypeRepository;
    }

    public LeaveType addLeaveType(LeaveTypeCreateRequest leaveTypeCreateRequest) {
        LeaveType leaveType = new LeaveType();
        leaveType.setName(leaveTypeCreateRequest.getName());
        leaveType.setDescription(leaveTypeCreateRequest.getDescription());
        leaveType.setType(leaveTypeCreateRequest.getType());
        return leaveTypeRepository.save(leaveType);
    }
}
