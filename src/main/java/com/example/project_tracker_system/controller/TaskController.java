package com.example.project_tracker_system.controller;


import com.example.project_tracker_system.dto.TaskDTO;
import com.example.project_tracker_system.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@AllArgsConstructor

public class TaskController {

    private final TaskService taskService;

    @PostMapping("/tasks")
    public TaskDTO saveTask(@RequestBody TaskDTO taskDTO) {
        return taskService.createTask(taskDTO);
    }

    @GetMapping("/tasks/{id}")
    public TaskDTO getTaskInfo(@PathVariable("id") Long id) {
        return taskService.getTask(id);
    }
}
