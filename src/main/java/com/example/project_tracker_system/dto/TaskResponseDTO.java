package com.example.project_tracker_system.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter

public class TaskResponseDTO {
    public Long id;
    private String name;
    private String description;
    private String status;
    private AssigneeDTO assignee;
}
