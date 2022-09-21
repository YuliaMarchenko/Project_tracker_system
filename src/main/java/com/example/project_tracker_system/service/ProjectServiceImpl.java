package com.example.project_tracker_system.service;

import com.example.project_tracker_system.dto.*;
import com.example.project_tracker_system.entities.Project;
import com.example.project_tracker_system.repository.ProjectRepository;
import com.example.project_tracker_system.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProjectService")
@AllArgsConstructor

public class ProjectServiceImpl implements ProjectService{

    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;

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
                        .tasksCount(taskRepository.countTasks(project.getId()))
                        .build()).toList();
    }

    @Override
    public ProjectInfoDTO getProjectInfo(Long id) {

        Project project = projectRepository.findById(id).get();

        return ProjectInfoDTO.builder()
                .id(project.getId())
                .name(project.getName())
                .tasksCount(taskRepository.countTasks(id))
                .build();
    }

    @Override
    public ProjectInfoFullDTO getProjectInfoFull(Long id) {

        Project project = projectRepository.findById(id).get();

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
                                        .assignee(AssigneeDTO.builder().id(task.getAssigneeId()).name(task.getAssignee().getName()).build())
                                        .build()).toList()
                )
                .build();
    }
}
