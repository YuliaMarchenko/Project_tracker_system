package com.example.project_tracker_system.service;

import com.example.project_tracker_system.dto.ProjectDTO;
import com.example.project_tracker_system.dto.ProjectResponseDTO;

public interface ProjectService {

    ProjectDTO createProject(ProjectDTO projectDTO);
    ProjectResponseDTO getProjectInfoWithTasksCount(Long id);
}
