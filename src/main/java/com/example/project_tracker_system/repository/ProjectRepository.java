package com.example.project_tracker_system.repository;

import com.example.project_tracker_system.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
