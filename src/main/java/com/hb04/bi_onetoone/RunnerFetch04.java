package com.hb04.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RunnerFetch04 {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student04.class).addAnnotatedClass(Diary04.class);
        SessionFactory sf =  con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx =  session.beginTransaction();

//        //Belli id li Student i getirelim
//
//        Student04 student = session.get(Student04.class, 1001);
////      Diaryget edelim
//        Diary04 diary = session.get(Diary04.class, 101);
//        System.out.println(student);
//        System.out.println("****************************************");
//        System.out.println(diary);
//        System.out.println("****************************************");
//        System.out.println(diary.getStudent());
//        System.out.println("****************************************");
//        System.out.println(student.getDiary());

//      Kesisim kumesini getirelim   =>  Inner join
        String  hqlQuery = "SELECT s.name,d.name FROM Student04 s INNER JOIN FETCH  Diary04 d on s.id=d.student";
        // üstteki HQL kodun   SQL  hali : SELECT  s.std_name,d.name FROM  t_student04 s  INNER JOIN diary04 d  on s.id=d.std_id;
        List<Object[]>  resultList =  session.createQuery(hqlQuery).getResultList();

        for (Object[] object : resultList) {
            System.out.println(Arrays.toString(object));
        }

        //Lambda Expression   da ayni seyi yapiyor
//        resultList.forEach(oa ->{
//            System.out.println(Arrays.toString(oa));
//                });

//  --------------------------------------------------------------------------------------------------------------------
        // ****  LEFT JOIN  ****
        // Kisaca bütün ögrenciler ve kitabi olan ögrencileri  istiyorum

//        String hqlQuery2 =
//                "SELECT  s.name, d.name FROM Student04 s LEF  JOIN FETCH Diary04 d on s.id = d.student";
//        List<Object[]> resultList2  =  session.createQuery(hqlQuery2).getResultList();
//        resultList2.forEach(oa->{
//            System.out.println(Arrays.toString(oa));
//        });
//  --------------------------------------------------------------------------------------------------------------------
        //HQL RIGHT  JOIN
        //kisaca  : Bütün günlükler ve günlügü olan ögrenciler

        String hqlQuery3 =
                "SELECT s.name,  d.name FROM  Student04 s RIGHT JOIN FETCH Diary04 d  on s.id = d.student";
        List<Object[]> resultList3 =  session.createQuery(hqlQuery3).getResultList();
            resultList3.forEach(oa -> {
                System.out.println(Arrays.toString(oa));
            });
//  --------------------------------------------------------------------------------------------------------------------
        //HQL FULL  JOIN
        //kisaca  : Bütün günlükler ve günlügü olan ögrenciler

        String hqlQuery4 =
                "SELECT s.name,  d.name FROM  Student04 s FULL JOIN FETCH Diary04 d  on s.id = d.student";
        List<Object[]> resultList4 =  session.createQuery(hqlQuery4).getResultList();
        resultList4.forEach(oa -> {
            System.out.println(Arrays.toString(oa));
        });

        tx.commit();
        session.close();
        sf.close();
    }
}
