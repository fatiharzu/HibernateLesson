package com.hb11.criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.query.QueryProducer;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class RunnerFetch11 {

    /*
    CRUD (Create, Read, Update, Delete)

    C --> session.save
    R --> session.get, HQL, SQL
    U --> session.update, updateQuery
    D --> session.delete, HQL, SQL

     */

    /***
     * Bu sorgu, veritabanında "Student11" tablosunun "mathGrade" sütununda bulunan verileri güncellemek için kullanılır.
     * "SET s.mathGrade=:sMath" ifadesi, "s.mathGrade" değerini ":sMath" değerine eşitler.
     * "WHERE s.mathGrade<:lMath" ifadesi ise, "s.mathGrade" değerinin ":lMath" değerinden küçük olduğu satırları seçer.
     * Bu sorguda, ":sMath" ve ":lMath" gibi etiketler girdi olarak kullanılmaktadır ve kullanıcı tarafından
     * belirli değerlerle değiştirilmelidir.
     * @param args
     */
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student11.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Student11 student = session.get(Student11.class, 1L);
//        student.setName("Güncellenmiş " + student.getName());
//        session.update(student);


        // !!! Değişken tanımla
//        int sMathGrade = 80 ;
//        int lMathGrade = 75 ;
//
//        String hqlQuery = "UPDATE Student11 s SET s.mathGrade=:sMath WHERE s.mathGrade<:lMath";
//        Query query = session.createQuery(hqlQuery);
//
//        query.setParameter("sMath", sMathGrade);
//        query.setParameter("lMath" , lMathGrade);
//        int numOfRecords = query.executeUpdate();
//        System.out.println("Değiştirilen kayıt sayısı : " + numOfRecords);


        // CriteriaAPI ****************************************

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Student11> criteriaQuery = cb.createQuery(Student11.class);
        Root<Student11> root = criteriaQuery.from(Student11.class);

        // 1.Örnek
//        criteriaQuery.select(root);
//        Query<Student11> query1 = session.createQuery(criteriaQuery);
//        List<Student11>  resultList = query1.getResultList();
//                resultList.forEach(s-> System.out.println(s));

        // 2.Örnek
//        criteriaQuery.select(root).
//                    where(cb.equal(root.get("name"),"Student Name 6"));
//        Query<Student11> query2 = session.createQuery(criteriaQuery);
//           List<Student11> resultList2 =  query2.getResultList();
//                    resultList2.forEach(s->{
//                        System.out.println(s);
//                    });
        // 3. Örnek

//        criteriaQuery.select(root).where(cb.greaterThan(root.get("mathGrade"), 80));
//        Query<Student11> query3 = session.createQuery(criteriaQuery);
//                List<Student11> resultList3 = query3.getResultList();
//                    resultList3.forEach(s-> System.out.println(s));


        // 4. Örnek
//        criteriaQuery.select(root).where(cb.lessThan(root.get("mathGrade"), 95));
//        Query<Student11> query4 = session.createQuery(criteriaQuery);
//        List<Student11> resultList4 = query4.getResultList();
//        resultList4.forEach(s-> System.out.println(s));

        // 5. Örnek : id si 1 veya mathGrade i 75 den büyük olan recordu bulalaim.

        Long id = 1L;

        Predicate predicateForId = cb.equal(root.get("id"), id);
        Predicate predicateForMathGrade = cb.equal(root.get("mathGrade"),75);

        Predicate predicateQuery = cb.or(predicateForId, predicateForMathGrade);

        criteriaQuery.where(predicateQuery);
        Query<Student11> query5 = session.createQuery(criteriaQuery);
        List<Student11> resultList6 = query5.getResultList();
        resultList6.forEach(System.out::println);

        tx.commit();
        session.close();
        sf.close();
    }
}
