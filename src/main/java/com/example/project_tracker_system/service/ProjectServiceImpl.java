package com.example.project_tracker_system.service;

import com.example.project_tracker_system.dto.*;
import com.example.project_tracker_system.entities.Project;
import com.example.project_tracker_system.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service("ProjectService")
@AllArgsConstructor

public class ProjectServiceImpl implements ProjectService {

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
    public List<ProjectInfoDTO> getProjects() {

        List<Project> projects = projectRepository.findAll();

        return projects.stream()
                .map(project -> ProjectInfoDTO.builder()
                        .id(project.getId())
                        .name(project.getName())
                        .tasksCount(project.getTasks().size())
                        .build()).toList();
    }

    @Override
    public ProjectInfoDTO getProjectInfo(Long id) {

        Project project = projectRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return ProjectInfoDTO.builder()
                .id(project.getId())
                .name(project.getName())
                .tasksCount(project.getTasks().size())
                .build();
    }

    @Override
    public ProjectInfoFullDTO getProjectInfoFull(Long id) {

        Project project = projectRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return ProjectInfoFullDTO.builder()
                .id(project.getId())
                .name(project.getName())
                .tasks(
                        project.getTasks().stream()
                                .map(task -> TaskResponseDTO.builder()
                                        .id(task.getId())
                                        .name(task.getName())
                                        .description(task.getDescription())
                                        .status(task.getStatus())
                                        .assignee(AssigneeDTO.builder().id(task.getAssignee().getId()).name(task.getAssignee().getName()).build())
                                        .build()).toList()
                )
                .build();
    }
}
