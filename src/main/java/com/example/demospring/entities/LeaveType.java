package com.example.demospring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "LeaveTypes")
@Data
public class LeaveType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private int type;

    @JsonIgnore
    @OneToMany(mappedBy = "leaveType")
    private List<Leave> leaves;
}
