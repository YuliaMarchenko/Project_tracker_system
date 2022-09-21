package com.example.project_tracker_system.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tasks")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "project_id", insertable = false, updatable = false)
    private Project project;

    @Column(name = "project_id")
    private Long projectId;

    @ManyToOne
    @JoinColumn(name = "assignee_id", insertable = false, updatable = false)
    private Assignee assignee;

    @Column(name = "assignee_id")
    private Long assigneeId;
}
