package com.hb13.get_load;
/**
 * get () ve load() Metot Farkları
 * Hibernate Session , veritabanından veri almak için farklı yöntemler sağlar. Bunlardan ikisi - get() ve load()'dur .
 * Ayrıca bunlar için farklı durumlarda kullanabileceğimiz çok fazla overload yöntem var.
 * İlk bakışta her ikisi de get() benzer load() görünüyor gibi görünse de
 * (çünkü her ikisi de veri tabanından veri getiriyor) ancak aralarında bazı farklar vardır.
 * get() metodu kullanarak bir id ile sorgu yapıldığında eğer kayıt bulunumaz ise null döndürür.
 * get() metodu kullanarak bir id ile sorgu yapıldığında dönen nesne üzerinde bir özellik çağrımı yapıldığında
 * ObjectNotFoundException throw edilecektir.
 * get () metodu verileri çağrıldığı anda yüklerken load() bir proxy nesnesi döndürür.
 * get () metodu getirmek için kullanılırken load() metodu delete isteği için kullanılabilir.
 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
/*
/*
   get() ---> gerçek nesneyi döndürür ,
               nesne yoksa null döner
               nesnenin olduğundan emin değilseniz get() kullanın
               dönen nesneye hemen kullanacaksam get() kullanılmalı
   load() --> proxy nesne döndürür, gerçek nesnenin gölgesi ,
               nesne yoksa exception fırlatır
               dönen nesne üzerinde delete yapılacaksa kullanılabilir
 */

public class RunnerFetch13 {
    public static void main(String[] args) {

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student13.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


//        System.out.println("Get methodunun basladigi yer....");
//        Student13 student1 = session.get(Student13.class,1L);
//        System.out.println("Get methdounun bittigi satir....");
//        System.out.println("student1.getId() = " + student1.getId());
//        System.out.println("Student get Name : " + student1.getName());
//
//        System.out.println("=====================================================================");
//        //Yukardaki senaryonun aynisini load() methodu ile yapalim
//        System.out.println("Load methodunun baslangic yeri........");
//        Student13 student2 = session.load(Student13.class, 2L);
//        System.out.println("getName() cagirildi...");
//        System.out.println("Student2 nin ismi : " + student2.getName());
//        System.out.println("getName() bitti..");
//        System.out.println("Load methodunun bittigi satir........");

        //DB de olmayan  id yi cagirirsak ?

//        System.out.println("get() methodu calismaya basladi : ");
//        Student13 student3 =  session.get(Student13.class,5L);
//        System.out.println("get() methodu bitti");
//
//        if (student3 != null)
//        {
//            System.out.println("Student ID : " + student3.getId());
//            System.out.println("Student Get Name : " +  student3.getName());
//        }
//        System.out.println("=================================================");
//        System.out.println("load() methodu calismaya basladi");
//        Student13 student4 = session.load(Student13.class, 10L);
//        System.out.println("load() methodu bitti");
//
//        if (student4 != null)
//        {
//            System.out.println("Student ID : " + student4.getId()); // ObjectNotFoundException
//            System.out.println("Student Get Name : " +  student4.getName());
//        }

        // Peki load() Methodunu niye kullanayim ???

//        Student13 student5 = session.get(Student13.class, 1L);
//        session.delete(student5);
        // load methodu ile obje referansi alinir ve sonra delete cagirilir...
        // get methodu cagirilmayarak DB ye hit engellenmis olur..
        Student13 student6 = session.load(Student13.class,1L);
        session.delete(student6);

        tx.commit();
        session.close();
        sf.close();
    }
}
