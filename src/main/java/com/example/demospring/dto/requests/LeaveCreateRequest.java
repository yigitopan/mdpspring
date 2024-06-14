package com.example.demospring.dto.requests;

import lombok.Data;

import java.util.Date;

@Data
public class LeaveCreateRequest {
    private Long userId;
    private Long leaveTypeId;
    private Date startDate;
    private Date endDate;
}
