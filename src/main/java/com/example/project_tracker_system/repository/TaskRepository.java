package com.example.project_tracker_system.repository;

import com.example.project_tracker_system.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
