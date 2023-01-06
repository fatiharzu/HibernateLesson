package com.hb09.fetchtypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch09 {
    public static void main(String[] args) {
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student09.class).
                addAnnotatedClass(Book09.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // get mthodu sonra delete methodu kullanalim;

        Student09 std1 = session.get(Student09.class,1002);// Book3 , Book4
//        System.out.println(std1);
//        session.delete(std1);

//        Book09 book1 = session.get(Book09.class,101);
        for (Book09 book: std1.getBookList()){
            System.out.println(book);
        }


        tx.commit();
        session.close();


        /*
        (Student09 class inda) 26. satirda)
        EAGER yapida calisirken asagidaki sorguda hata almiyorken, FetchType LAZY olsaydi exception alacaktik.

         */
//        for (Book09 book: std1.getBookList()){
//            System.out.println(book);
//        }
        sf.close();
    }
}
