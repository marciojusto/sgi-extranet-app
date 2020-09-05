package com.sgi.extranet.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import static com.sgi.extranet.util.GlobalVariables.Entities.ID;
import static com.sgi.extranet.util.GlobalVariables.Entities.PUBLIC;
import static com.sgi.extranet.util.GlobalVariables.Type_Entity.TYPE_GENERATOR;
import static com.sgi.extranet.util.GlobalVariables.Type_Entity.TYPE_SEQUENCE;
import static com.sgi.extranet.util.GlobalVariables.Type_Entity.TYPE_TABLE;

@Data
@Entity
@Table(name = TYPE_TABLE, schema = PUBLIC)
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TYPE_GENERATOR)
    @SequenceGenerator(name = TYPE_GENERATOR, sequenceName = TYPE_SEQUENCE, allocationSize = 1)
    @Column(name = ID, updatable = false, nullable = false)
    private Integer id;

    private String description;

}
