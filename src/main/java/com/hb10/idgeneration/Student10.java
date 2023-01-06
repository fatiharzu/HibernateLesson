package com.hb10.idgeneration;

import javax.persistence.*;

@Entity
public class Student10 {
    /**
     * <lu>
     *     <h2>SQL</h2>
     *     <li>Oracle - PostgreSQL---------->> Sequence => kontrolu developer'a birakir Id uretilirken
     *     baslangic degeri veya kac tane id chache'lenecek bu gibi bilgileri developer setliyebilir</li>
     *     <li>MySQL - Microsoft SQL ------>> IDENTITY => kontrol DB de kendi yapisina gore id olusturur,
     *     iclerinde en basitidir.</li>
     *     <h2>GenerationType.AUTO</h2>
     *     <li>GenerationType.AUTO ----> Hibernate otomatik olarak stratejiyi belirler</li>
     *     <li>GenerationType.TABLE ----> En yavasi, o yuzden cok kullanilmiyor, cunku id üretmek icin
     *     ekstra tablo olusturuyor</li>
     * </lu>
     */
    @GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence", // @GeneratedValue nun generator parametresi ile ayni isimde olmasi lazim
                        sequenceName = "student_seq",// DB'de olusacak sequence ismi
                        initialValue = 1000, //idlerim 1000 ile baslasin
                        allocationSize = 10) // cache leme mekanimasinda 10 adet id hazir beklesin
    @Id
    private int id;

    @Column(name = "student_name", nullable = false)
    private String name;

    private int grade;

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
        return "Student10{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
