package com.example.project_tracker_system.service;

import com.example.project_tracker_system.dto.TaskDTO;
import com.example.project_tracker_system.entities.Task;
import com.example.project_tracker_system.repository.ProjectRepository;
import com.example.project_tracker_system.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("TaskService")
@AllArgsConstructor

public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    private final ProjectRepository projectRepository;

    @Override
    public TaskDTO createTask(TaskDTO taskDTO) {

        Task task = Task.builder()
                .name(taskDTO.getName())
                .description(taskDTO.getDescription())
                .status(taskDTO.getStatus())
                .projectId(taskDTO.getProjectId())
                .assigneeId(taskDTO.getAssigneeId())
                .build();

        task = taskRepository.save(task);

        taskDTO.setId(task.getId());

        return taskDTO;
    }

    @Override
    public TaskDTO getTask(Long id) {

       Task task = taskRepository.findById(id).get();

       return TaskDTO.builder()
               .id(task.getId())
               .name(task.getName())
               .description(task.getDescription())
               .status(task.getStatus())
               .build();
    }

}
