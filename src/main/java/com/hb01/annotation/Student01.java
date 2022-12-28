package com.hb01.annotation;

import javax.persistence.*;

//@Entity annotation i koydugumuz sinifini DB de bir tabloya karsilik gelir

@Entity
@Table(name="t_student01")// DB de tablo ismim "t_student01" olarak degisti.
public class Student01 { // DB ye gider "student01"  isminde tablo olusturur.

    //region Konstanten
    //endregion

    //region Attribute
    @Id // primary-key olusmasini saglar...
//    @Column(name="std_id")
    private int id;
//@Column zorunlu degildir, ancak customize edebilmek icin gereklidir
    @Column(name="student_name", length = 100,nullable = false, unique = false)
    private String name;

//    @Transient //DB deki tabloda grade adinda bir column olusmasini engeller
    private int grade;

//    @Lob // ---> large objec..t ile buyuk bpyutlu  datalar tutulabilir
//    private byte[]  image;

    //endregion

    //region Konstruktor
    //endregion

    //region Methoden

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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }


    @Override
    public String toString() {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

    //endregion



}
