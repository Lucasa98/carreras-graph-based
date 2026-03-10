package com.lucas.carreras.node;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.jspecify.annotations.Nullable;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

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

    public String getNombre() {
        return nombre;
    }

    public String toString() {
        return this.nombre;
    }
}
