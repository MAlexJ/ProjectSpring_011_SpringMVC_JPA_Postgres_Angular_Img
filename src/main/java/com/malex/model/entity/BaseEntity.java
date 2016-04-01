package com.malex.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class BaseEntity implements Serializable{

    @Id
    @SequenceGenerator(name = "app_sequence", sequenceName = "app_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "app_sequence")
    private Long id;

    public BaseEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
