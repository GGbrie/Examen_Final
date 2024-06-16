package com.codigofinalcurso.demo.repositories;

import com.codigofinalcurso.demo.entities.Tareas;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Tareas, Long> {
    List<Tareas> findByEstado(String estado);
}
