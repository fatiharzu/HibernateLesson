package com.practice.manytoone;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class University {
    @Id
    private int id;

    private String name;

}
