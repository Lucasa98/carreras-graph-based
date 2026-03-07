package com.lucas.carreras;

import org.jspecify.annotations.Nullable;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface MateriaRepository extends Neo4jRepository<Materia, Long> {
    @Nullable
    Materia findByNombre(String nombre);
}
