package com.example.project_tracker_system.service;

import com.example.project_tracker_system.dto.ProjectDTO;

public interface ProjectService {

    ProjectDTO createProject(ProjectDTO projectDTO);

    ProjectDTO getProjectInfo(Long id);
}
