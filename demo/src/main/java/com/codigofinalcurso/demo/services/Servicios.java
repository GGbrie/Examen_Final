package com.codigofinalcurso.demo.services;

import com.codigofinalcurso.demo.entities.Tareas;
import java.util.List;

public interface Servicios {
    List<Tareas> findAll();
    Tareas findById(Long id);
    void create(Tareas tarea);
    void update(Long id, Tareas tarea);
    void delete(Long id);
}
