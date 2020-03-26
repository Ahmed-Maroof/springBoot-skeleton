package com.raya.aman.TrainAgent.model;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLES_SEQ")
    @SequenceGenerator(sequenceName = "ROLES_SEQ", allocationSize = 1, name = "ROLES_SEQ")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20 , name = "NAME")
    private ERole name;

    public Role() { }

    public Role(ERole name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }
}
