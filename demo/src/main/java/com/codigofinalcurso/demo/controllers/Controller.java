package com.codigofinalcurso.demo.controllers;

import com.codigofinalcurso.demo.entities.Tareas;
import com.codigofinalcurso.demo.services.Servicios;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tareas")
public class Controller {

    private final Servicios servicios;
    public Controller(Servicios servicios) {
        this.servicios = servicios;
    }
    @GetMapping
    public ResponseEntity<List<Tareas>> getAll() {
        List<Tareas> tareasList = servicios.findAll();
        return new ResponseEntity<>(tareasList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Tareas> getById(@PathVariable Long id) {
        Tareas tarea = servicios.findById(id);
        if (tarea != null) {
            return new ResponseEntity<>(tarea, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Tareas tarea) {
        if (servicios.findById(id) != null) {
            servicios.update(id, tarea);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (servicios.findById(id) != null) {
            servicios.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
