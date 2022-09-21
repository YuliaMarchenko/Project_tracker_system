package com.example.project_tracker_system.service;

import com.example.project_tracker_system.dto.AssigneeDTO;

public interface AssigneeService {

    AssigneeDTO createAssignee (AssigneeDTO assigneeDTO);

    AssigneeDTO getAssignee (Long id);
}
