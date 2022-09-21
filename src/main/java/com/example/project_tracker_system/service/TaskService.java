package com.example.project_tracker_system.service;

import com.example.project_tracker_system.dto.TaskDTO;

import java.util.List;

public interface TaskService {

    TaskDTO createTask (TaskDTO taskDTO);
    TaskDTO getTask (Long id);
}
