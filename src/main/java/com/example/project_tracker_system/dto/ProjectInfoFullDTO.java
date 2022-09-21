package com.example.project_tracker_system.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter

public class ProjectInfoFullDTO {

    public Long id;
    private String name;
    private List<TaskResponseDTO> tasks;
}
