package com.sgi.extranet.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Set;

import static com.sgi.extranet.util.GlobalVariables.Entities.ID;
import static com.sgi.extranet.util.GlobalVariables.Entities.PUBLIC;
import static com.sgi.extranet.util.GlobalVariables.Type_Entity.TYPE_ID;
import static com.sgi.extranet.util.GlobalVariables.User_Entity.USER_GENERATOR;
import static com.sgi.extranet.util.GlobalVariables.User_Entity.USER_ID;
import static com.sgi.extranet.util.GlobalVariables.User_Entity.USER_SEQUENCE;
import static com.sgi.extranet.util.GlobalVariables.User_Entity.USER_TABLE;
import static com.sgi.extranet.util.GlobalVariables.User_Type_Entity.USER_TYPE_TABLE;

@Data
@Entity
@Table(name = USER_TABLE, schema = PUBLIC)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = USER_GENERATOR)
    @SequenceGenerator(name = USER_GENERATOR, sequenceName = USER_SEQUENCE, allocationSize = 1)
    @Column(name = ID, updatable = false, nullable = false)
    private Long id = -1L;

    private String name;
    private String lastname;
    private Integer age;
    private String phone;

    @Column(name = "mobile_phone")
    private String mobilePhone;

    private String email;

    private Long nif;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable( name = USER_TYPE_TABLE,
                joinColumns = @JoinColumn(name = USER_ID, referencedColumnName = ID),
                inverseJoinColumns = @JoinColumn(name = TYPE_ID, referencedColumnName = ID))
    private Set<Type> types;
}
