package com.hb14.entity_life_cycle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave14 {
    public static void main(String[] args) {

        Student14 student1 = new Student14();  // !! Transient state
        student1.setName("Recep Bey");
        student1.setMathGrade(99);

        Student14 student2 = new Student14();  // !! Transient state
        student1.setName("Emir Bey");
        student1.setMathGrade(99);

        Student14 student3 = new Student14();  // !! Transient state
        student1.setName("Tarik Bey");
        student1.setMathGrade(99);

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student14.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);  //persisted State

        student1.setName("Güncellenmis Recep Bey");

        session.evict(student1);  // Detached e gecti

        session.update(student1); // detached olmus student1 objesini persisted State e alir

        tx.commit();
        session.close();
        sf.close();
    }
}
