package com.example.project_tracker_system.repository;

import com.example.project_tracker_system.entities.Assignee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssigneeRepository extends JpaRepository<Assignee, Long> {
}
