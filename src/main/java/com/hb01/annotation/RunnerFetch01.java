package com.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RunnerFetch01 {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);


        SessionFactory  sf  = con.buildSessionFactory();
        Session session =  sf.openSession();

        Transaction tx  = session.beginTransaction();

        //DB den bilgi almak icin 3 yol:
        //  1) get()
        //  2)  SQL
        //  3)  HQL
//      1.YOL  get() .........................................................................
//        Student01 student01 = session.get(Student01.class, 1001);
//        Student01 student02 = session.get(Student01.class, 1002);
//        Student01 student03 = session.get(Student01.class, 1003);
//        Student01 student04 = session.get(Student01.class, 1004);
//        Student01 student05 = session.get(Student01.class, 1005);
//        System.out.println(student01);
//        System.out.println(student02);
//        System.out.println(student03);
//        System.out.println(student04);
//        System.out.println(student05);

//      2.YOL SQL ...........................................................................

//        String sqlQuery  = "SELECT * FROM t_student01";
//        List<Object[]> resultList = session.createSQLQuery(sqlQuery).getResultList();
//        for (Object[] objects : resultList) {
//            System.out.println(Arrays
//                    .toString(objects));
//        }

//        3.YOL HQL .........................................................................
        // Trick: SQL  sorgusunda FROM dan sonra sinif ismi kullanilmali
//        String hqlQuery = "FROM Student01";
//        List<Student01>resultList2=session.createQuery(hqlQuery, Student01.class).getResultList();
//
//            for (Student01 student01:resultList2) {
//                System.out.println(student01);
//            }

//        3-1-2
//---------------------------------------------------------------------------------------------------
    //      Donecek kaydin unique (tek bir tane) oldugundan emin iseniz uniqueResult() methodu kullanilabilir
//
//        String sqlQuery2 = "SELECT * FROM t_student01 WHERE student_name='Fatih Arzu'";
//        Object[] uniqueResult1 = (Object[]) session.createSQLQuery(sqlQuery2).uniqueResult();
//        System.out.println(Arrays.toString(uniqueResult1));
//
//        //Yukarida 1 obje gelece ama icinde kalanlar oldugu icin array türünde obje geldi.
//
//        System.out.println(uniqueResult1[0] +  " : " + uniqueResult1[1] +  " : " + uniqueResult1[2]);

        //unqueResult()  with HQL  ..............................................................
//            String hqlQuery2 = "FROM Student01 WHERE name='Arzu'";
//            Student01  uniqueResult2 = session.createQuery(hqlQuery2, Student01.class).uniqueResult();
//        System.out.println(uniqueResult2);
//  --------------------------------------------------------------------------------------------------------------------
        //yukaridaki sorguyu HQL Alias kullanarak yapalim
//       String hqlQuery3 = "FROM Student01 std WHERE std.name='Mirac'";
//        Student01 uniqueResult3 = session.createQuery(hqlQuery3, Student01.class).uniqueResult();
//        System.out.println(uniqueResult3);
//
//
        //grade degeri 90 olan ogrenciyi getirelim
        String hqlQuery4 = "SELECT s.id,s.name FROM Student01 s WHERE s.grade=90";

        // createQuery metoduna tek parametre girdiğimiz için Student01 clası ile mappleme işlemi yapılmadı
        // bu yüzden Object olarak aldık

        List<Object []> resultlist3 = session.createQuery(hqlQuery4).getResultList();
        for (Object[] object: resultlist3) {
            System.out.println(Arrays.toString(object));
        }


        tx.commit();

        session.close();
        sf.close();
    }
}
