package com.example.project_tracker_system.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "projects")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "project")
    private List<Task> tasks;
}
