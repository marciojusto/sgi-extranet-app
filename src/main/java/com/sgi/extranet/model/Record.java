package com.sgi.extranet.model;

import com.sgi.extranet.enums.UserType;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import java.sql.Date;

import static com.sgi.extranet.util.GlobalVariables.History_Entity.RECORD_GENERATOR;
import static com.sgi.extranet.util.GlobalVariables.History_Entity.RECORD_SEQUENCE;

@Data
@Entity
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = RECORD_GENERATOR)
    @SequenceGenerator(name = RECORD_GENERATOR, sequenceName = RECORD_SEQUENCE, allocationSize = 1)
    private Long id;

    private Date initialDate;

    private Date finalDate;

    @Enumerated(EnumType.STRING)
    private UserType type;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

}
