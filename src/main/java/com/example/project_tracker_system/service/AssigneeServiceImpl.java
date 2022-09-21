package com.example.project_tracker_system.service;

import com.example.project_tracker_system.dto.AssigneeDTO;
import com.example.project_tracker_system.entities.Assignee;
import com.example.project_tracker_system.repository.AssigneeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service("AssigneeService")
@AllArgsConstructor

public class AssigneeServiceImpl implements AssigneeService{

    private final AssigneeRepository assigneeRepository;

    @Override
    public AssigneeDTO createAssignee(AssigneeDTO assigneeDTO) {

        Assignee assignee = Assignee.builder().name(assigneeDTO.getName()).build();

        assignee = assigneeRepository.save(assignee);

        assigneeDTO.setId(assignee.getId());

        return assigneeDTO;
    }

    @Override
    public AssigneeDTO getAssignee(Long id) {

        Assignee assignee = assigneeRepository.findById(id).get();

        return AssigneeDTO.builder().id(assignee.getId()).name(assignee.getName()).build();
    }
}
