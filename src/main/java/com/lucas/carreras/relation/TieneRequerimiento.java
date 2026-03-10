package com.lucas.carreras.relation;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import com.lucas.carreras.node.Requerimiento;

@RelationshipProperties
public class TieneRequerimiento {
    @Id
    @GeneratedValue
    private Long id;

    @TargetNode
    private final Requerimiento requerimiento;

    private String type;

    public TieneRequerimiento(Requerimiento requerimiento, String type) {
        this.requerimiento = requerimiento;
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
