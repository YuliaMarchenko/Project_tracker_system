package com.example.project_tracker_system.service;

import com.example.project_tracker_system.dto.ProjectDTO;
import com.example.project_tracker_system.dto.ProjectResponseDTO;

import java.util.List;

public interface ProjectService {

    ProjectDTO createProject(ProjectDTO projectDTO);
    List<ProjectResponseDTO> getProjects();
    ProjectResponseDTO getProjectInfoWithTasksCount(Long id);
}
