package com.example.project_tracker_system.service;

import com.example.project_tracker_system.dto.ProjectDTO;
import com.example.project_tracker_system.entities.Project;
import com.example.project_tracker_system.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service("ProjectService")
@AllArgsConstructor

public class ProjectServiceImpl implements ProjectService{

    private final ProjectRepository projectRepository;

    @Override
    public ProjectDTO createProject(ProjectDTO projectDTO) {

        Project project = Project.builder()
                .name(projectDTO.getName())
                .description(projectDTO.getDescription())
                .build();

        project = projectRepository.save(project);

        projectDTO.setId(project.getId());

        return projectDTO;
    }

    @Override
    public ProjectDTO getProjectInfo(Long id) {

        Project project = projectRepository.findById(id).get();

        return ProjectDTO.builder()
                .id(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .build();
    }
}
