package com.example.project_tracker_system.controller;

import com.example.project_tracker_system.dto.ProjectDTO;
import com.example.project_tracker_system.dto.ProjectInfoDTO;
import com.example.project_tracker_system.dto.ProjectInfoFullDTO;
import com.example.project_tracker_system.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("/projects")
    public ProjectDTO saveProject(@RequestBody ProjectDTO projectDTO) {
        return projectService.createProject(projectDTO);
    }

    @GetMapping("/projects/{id}")
    public ProjectInfoDTO getProjectInfo(@PathVariable("id") Long id) {
        return projectService.getProjectInfo(id);
    }

    @GetMapping("/projects")
    public List<ProjectInfoDTO> getProjects() {
        return projectService.getProjects();
    }

    @GetMapping("/projects/{id}/full")
    public ProjectInfoFullDTO getProjectInfoFull(@PathVariable("id") Long id) {
        return projectService.getProjectInfoFull(id);
    }
}
