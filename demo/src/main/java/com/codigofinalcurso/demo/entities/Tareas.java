package com.codigofinalcurso.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Entity
@Table(name = "Tareas")
@Getter
@Setter
public class Tareas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @Column(name = "created")
    @Temporal(TemporalType.DATE)
    private Date createdAt;
}
