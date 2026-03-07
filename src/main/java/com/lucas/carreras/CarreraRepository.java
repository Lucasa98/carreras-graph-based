package com.lucas.carreras;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CarreraRepository extends Neo4jRepository<Carrera, Long> {
    @Nullable
    Carrera findByNombre(String nombre);
}
