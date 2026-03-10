package com.lucas.carreras.repository;

import org.jspecify.annotations.Nullable;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.lucas.carreras.node.Materia;

public interface MateriaRepository extends Neo4jRepository<Materia, Long> {
    @Nullable
    Materia findByNombre(String nombre);
}
