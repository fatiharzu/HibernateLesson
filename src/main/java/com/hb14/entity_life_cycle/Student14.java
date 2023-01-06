package com.hb14.entity_life_cycle;

import javax.persistence.*;

@Entity
public class Student14 {
    /*
    Hibernate in Objeler ile nasıl çalıştığı ile ilgili ek bilgi :
       Entity State :
          *) Transient : Objenin newlenmiş hali, DB ile ilişkisi yok.

          *) Persisted or Managed : DB de row a karşılık geldiği durum,
                            save(),get() vs. yapıldığı zamana denk geliyor.

          *) Detached : Session kapandıktan sonra elimizdeki objenin state durumu.

          *) Removed : obje remove yapıldığı zmanki durum.
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "student_name", nullable = false)
    private String name;

    private int mathGrade;


    //Getter-Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMathGrade() {
        return mathGrade;
    }

    public void setMathGrade(int mathGrade) {
        this.mathGrade = mathGrade;
    }

    //toString()
    @Override
    public String toString() {
        return "Student14{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mathGrade=" + mathGrade +
                '}';
    }
}
