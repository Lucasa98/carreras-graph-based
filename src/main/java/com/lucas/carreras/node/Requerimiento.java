package com.lucas.carreras.node;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.jspecify.annotations.Nullable;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import com.lucas.carreras.relation.Necesita;

@Node
public class Requerimiento {
    @Id
    @GeneratedValue
    private @Nullable Long id;

    public Requerimiento() {
        // Empty constructor required
    }

    public Long getId() {
        return this.id;
    }

    @Relationship(type = "NECESITA")
    public Set<Necesita> materias;

    public void necesita(Materia materia, String condicionMin) {
        if (materias == null) {
            materias = new HashSet<>();
        }
        materias.add(new Necesita(materia, condicionMin));
    }

    public String toString() {
        String s = (this.materias == null) ? "" :
            this.materias.stream()
                .map(Necesita::toString)
                .collect(Collectors.joining(", "));
        return "Necesita: {" + s + "}";
    }
}
