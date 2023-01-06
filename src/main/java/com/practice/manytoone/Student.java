package com.practice.manytoone;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    private int id;

    private String name;

    private int grade;
}
