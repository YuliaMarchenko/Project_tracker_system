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
}
