package com.lucas.carreras;

import java.util.HashSet;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public class Carrera {
    @Id
    @GeneratedValue
    private @Nullable Long id;

    private String nombre;

    private int plan;

    private Carrera() {
        // Empty constructor required
    }

    public Carrera(String nombre, int plan) {
        this.nombre = nombre;
        this.plan = plan;
    }

    @Relationship(type = "DICTA")
    public Set<Dicta> materias;

    public void dicta(Materia materia, Integer numeracion, Integer cuatrimestre) {
        if (materias == null) {
            materias = new HashSet<>();
        }
        materias.add(new Dicta(materia, numeracion, cuatrimestre));
    }

    public String toString() {
        return this.nombre + "[" + this.plan + "]";
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getPlan() {
        return this.plan;
    }
}
