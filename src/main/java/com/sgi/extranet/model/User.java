package com.sgi.extranet.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
import static com.sgi.extranet.util.GlobalVariables.User_Entity.USER_GENERATOR;
import static com.sgi.extranet.util.GlobalVariables.User_Entity.USER_SEQUENCE;
import static com.sgi.extranet.util.GlobalVariables.User_Entity.USER_TABLE;

@Data
@Entity
@Table(name = USER_TABLE, schema = PUBLIC)
@JsonIgnoreProperties("user")
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

}
