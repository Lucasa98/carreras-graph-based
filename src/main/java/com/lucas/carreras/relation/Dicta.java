package com.lucas.carreras.relation;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import com.lucas.carreras.node.Materia;

@RelationshipProperties
public class Dicta {

    @Id
    @GeneratedValue
    private Long id;

    @TargetNode
    private final Materia materia;

    private Integer numeracion;

    private Integer cuatrimestre;

    public Dicta(Materia materia, Integer numeracion, Integer cuatrimestre) {
        this.materia = materia;
        this.numeracion = numeracion;
        this.cuatrimestre = cuatrimestre;
    }

    public String toString() {
        return "(n:" + this.numeracion + ", c:" + this.cuatrimestre + ") " + this.materia.toString();
    }

    public Integer getNumeracion() {
        return this.numeracion;
    }

    public Integer getCuatrimestre() {
        return this.cuatrimestre;
    }

    public Materia getMateria() {
        return this.materia;
    }
}
