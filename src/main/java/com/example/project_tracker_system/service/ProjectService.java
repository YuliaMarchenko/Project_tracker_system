package com.example.project_tracker_system.service;

import com.example.project_tracker_system.dto.ProjectDTO;
import com.example.project_tracker_system.dto.ProjectInfoDTO;
import com.example.project_tracker_system.dto.ProjectInfoFullDTO;

import java.util.List;

public interface ProjectService {

    ProjectDTO createProject(ProjectDTO projectDTO);
    List<ProjectInfoDTO> getProjects();
    ProjectInfoDTO getProjectInfo(Long id);
    ProjectInfoFullDTO getProjectInfoFull(Long id);
}
