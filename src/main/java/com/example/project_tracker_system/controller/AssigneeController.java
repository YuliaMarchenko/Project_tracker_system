package com.example.project_tracker_system.controller;

import com.example.project_tracker_system.dto.AssigneeDTO;
import com.example.project_tracker_system.dto.TaskDTO;
import com.example.project_tracker_system.service.AssigneeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@AllArgsConstructor

public class AssigneeController {

    private final AssigneeService assigneeService;
    @PostMapping("/assignees")
    public AssigneeDTO saveAssignee(@RequestBody AssigneeDTO assigneeDTO){
        return assigneeService.createAssignee(assigneeDTO);
    }

    @GetMapping("/assignees/{id}")
    public AssigneeDTO getAssigneeInfo(@PathVariable("id") Long id){
        return assigneeService.getAssignee(id);
    }
}
