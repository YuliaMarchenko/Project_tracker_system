package com.example.project_tracker_system.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "assignees")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class Assignee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "assignee")
    private List<Task> tasks;
}
