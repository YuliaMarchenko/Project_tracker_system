package com.example.project_tracker_system.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "assignee")

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
}
