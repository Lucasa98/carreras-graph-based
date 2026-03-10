package com.lucas.carreras.node;

import java.util.HashSet;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import com.lucas.carreras.relation.TieneRequerimiento;

@Node
public class Materia {
    @Id
    @GeneratedValue
    private @Nullable Long id;

    private String nombre;

    private Materia() {
        // Empty constructor required
    }

    public Materia(String nombre) {
        this.nombre = nombre;
    }

    @Relationship(type = "TIENE_REQUERIMIENTO")
    public Set<TieneRequerimiento> requerimientos;

    public void requiere(Requerimiento requerimiento, String type) {
        if (requerimientos == null) {
            requerimientos = new HashSet<>();
        }
        requerimientos.add(new TieneRequerimiento(requerimiento, type));
    }

    public String getNombre() {
        return nombre;
    }

    public String toString() {
        return this.nombre;
    }
}
