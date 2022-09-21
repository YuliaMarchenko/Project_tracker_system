package com.example.project_tracker_system.service;

import com.example.project_tracker_system.dto.TaskDTO;
import com.example.project_tracker_system.entities.Assignee;
import com.example.project_tracker_system.entities.Project;
import com.example.project_tracker_system.entities.Task;
import com.example.project_tracker_system.repository.AssigneeRepository;
import com.example.project_tracker_system.repository.ProjectRepository;
import com.example.project_tracker_system.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service("TaskService")
@AllArgsConstructor

public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;
    private final AssigneeRepository assigneeRepository;

    @Override
    public TaskDTO createTask(TaskDTO taskDTO) {
        Project project = projectRepository.findById(taskDTO.getProjectId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        Assignee assignee = assigneeRepository.findById(taskDTO.getAssigneeId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));

        Task task = Task.builder()
                .name(taskDTO.getName())
                .description(taskDTO.getDescription())
                .status(taskDTO.getStatus())
                .project(project)
                .assignee(assignee)
                .build();

        task = taskRepository.save(task);

        taskDTO.setId(task.getId());

        return taskDTO;
    }

    @Override
    public TaskDTO getTask(Long id) {

        Task task = taskRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return TaskDTO.builder()
                .id(task.getId())
                .name(task.getName())
                .description(task.getDescription())
                .status(task.getStatus())
                .assigneeId(task.getAssignee().getId())
                .projectId(task.getProject().getId())
                .build();
    }

}
