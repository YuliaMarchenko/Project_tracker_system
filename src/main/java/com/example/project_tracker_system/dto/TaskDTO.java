package com.example.project_tracker_system.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter

public class TaskDTO {
    public Long id;
    private String name;
    private String description;
    private String status;
    private Long assigneeId;
    private Long projectId;
}
