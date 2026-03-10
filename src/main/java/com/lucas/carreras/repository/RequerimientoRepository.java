package com.lucas.carreras.repository;

import java.util.Optional;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import com.lucas.carreras.node.Requerimiento;

public interface RequerimientoRepository extends Neo4jRepository<Requerimiento, Long> {
    @Query(
        "MATCH (m:Materia {nombre: $materiaNombre})-[h:TIENE_REQUERIMIENTO {type: $type}]->(r:Requerimiento) " +
        "MATCH (c:Carrera {nombre: $carreraNombre, plan: $carreraPlan})-[:APLICA]->(r) " +
        "MATCH (r)-[n:NECESITA]->(pre:Materia) " +
        "RETURN r, collect(n), collect(pre)"
    )
    Optional<Requerimiento> findByMateriaAndCarreraAndType(String materiaNombre, String carreraNombre, Integer carreraPlan, String type);
}
