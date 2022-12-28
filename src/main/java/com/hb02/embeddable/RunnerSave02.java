package com.hb02.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02 {

    public static void main(String[] args) {

        Student02  student01 = new Student02();
        student01.setId(1001);
        student01.setName("Tom Hanks");
        student01.setGrade(90);

        Address address1 =  new Address();

        address1.setStreet("Apple Street");
        address1.setCity("NewYork");
        address1.setCountry("US");
        address1.setZipCode("06852");

        student01.setAddress(address1);

        Address address2 =  new Address();
        address2.setStreet("Orange Street");
        address2.setCity("London");
        address2.setCountry("England");
        address2.setZipCode("03452");


        Student02  student02 = new Student02();
        student02.setId(1002);
        student02.setName("Carl Marx");
        student02.setGrade(90);
        student02.setAddress(address2);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student02.class);

        SessionFactory sf =  con.buildSessionFactory();
        Session  session = sf.openSession();
        Transaction tx =  session.beginTransaction();

        session.save(student01);
        session.save(student02);


        tx.commit();

        session.close();
        sf.close();


    }
}
