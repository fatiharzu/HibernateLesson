package com.hb03.uni_onetoone;
/**
 * Diary  den student classina ulasabiliyoriz ama aksi olmuyor  buna => uni directional deniyor
 *
 * enbedded de tablo olusmuyor one to one da iki tane tablo olusuoyr
 *
 * JoinColumn yaptığımızda Student Classında her zaman otomatik olarak Id'ye reference eder
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Diary {

    @Id
    private int id;

    private String name;

    @OneToOne
    @JoinColumn(name  = "std_id") // name parametresine set'lemessek default
                                    // deger  olarak student_id
    private Student03  student;

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

    public Student03 getStudent() {
        return student;
    }

    public void setStudent(Student03 student) {
        this.student = student;
    }

    //toString()

    @Override
    public String toString() {
        return "Diary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                '}';
    }
}
