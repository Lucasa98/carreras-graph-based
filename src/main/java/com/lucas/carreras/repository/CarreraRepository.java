package com.lucas.carreras.repository;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.lucas.carreras.node.Carrera;

public interface CarreraRepository extends Neo4jRepository<Carrera, Long> {
    @Nullable
    Carrera findByNombre(String nombre);
}
