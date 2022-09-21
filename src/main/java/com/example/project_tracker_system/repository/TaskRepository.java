package com.example.project_tracker_system.repository;

import com.example.project_tracker_system.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("select count(t) from Task t where t.projectId = :projectId")
    int countTasks(@Param("projectId") Long projectId);
}
