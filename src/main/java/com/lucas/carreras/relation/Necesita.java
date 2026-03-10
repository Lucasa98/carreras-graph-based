package com.lucas.carreras.relation;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import com.lucas.carreras.node.Materia;

@RelationshipProperties
public class Necesita {
    @Id
    @GeneratedValue
    private Long id;

    @TargetNode
    private final Materia materia;

    private String condicionMin;

    public Necesita(Materia materia, String condicionMin) {
        this.materia = materia;
        this.condicionMin = condicionMin;
    }

    public String getCondicionMin() {
        return this.condicionMin;
    }

    public String toString() {
        return this.materia.toString() + " " + this.condicionMin;
    }
}
