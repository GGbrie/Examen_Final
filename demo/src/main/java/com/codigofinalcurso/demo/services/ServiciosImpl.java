package com.codigofinalcurso.demo.services;

import com.codigofinalcurso.demo.entities.Tareas;
import com.codigofinalcurso.demo.repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public abstract class ServiciosImpl implements Servicios {
    private final Repository repository;
    @Autowired
    public ServiciosImpl(Repository repository) {
        this.repository = repository;
    }
    @Override
    public List<Tareas> findAll() {
        return repository.findAll();
    }
    /**
     * @param id ID de la tarea
     * @return
     */
    @Override
    public Tareas findById(Long id) {
        return repository.findById(id).orElse(null);
    }
    /**
     * @param tarea Datos de la tarea
     */
    @Override
    public void create(Tareas tarea) {
        repository.save(tarea);
    }
    /**
     * Actualizar una tarea existente.
     * @param id ID de la tarea a actualizar.
     * @param tarea Datos actualizados de la tarea.
     */
    @Override
    public void update(Long id, Tareas tarea) {
        if (repository.existsById(id)) {
            tarea.setId(id);
            repository.save(tarea);
        } else {
            throw new RuntimeException("Esta tarea no fue encontrada con su ID: " + id);
        }
    }
    /**
     * @param id
     */
    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Tarea no fue encontrada con el ID: " + id);
        }
    }
}
