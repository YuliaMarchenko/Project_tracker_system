package com.example.project_tracker_system.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter

public class ProjectDTO {
    public Long id;
    private String name;
    private String description;
}
