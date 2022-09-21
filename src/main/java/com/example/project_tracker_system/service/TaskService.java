package com.example.project_tracker_system.service;

import com.example.project_tracker_system.dto.TaskDTO;

public interface TaskService {

    TaskDTO createTask (TaskDTO taskDTO);
    TaskDTO getTask (Long id);
}
