package com.example.demospring.repositories;

import com.example.demospring.entities.LeaveType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveTypeRepository extends JpaRepository <LeaveType, Long> {
}
