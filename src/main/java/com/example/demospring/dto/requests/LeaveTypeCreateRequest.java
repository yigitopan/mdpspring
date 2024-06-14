package com.example.demospring.dto.requests;


import lombok.Data;

@Data
public class LeaveTypeCreateRequest {
    private String name;
    private String description;
    private int type;
}
