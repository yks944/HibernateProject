package org.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
    //Server=localhost;Database=master;Trusted_Connection=True;
        Student s1 = new Student();
        s1.setsName("Kumar");
        s1.setsRollNo(102);
        s1.setsAge(25);

        //config for defining class to be treated as entity
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(org.example.Student.class);
        cfg.configure();

        //session to connect to db  per application
        SessionFactory sf = cfg.buildSessionFactory();
        Session sess = sf.openSession();

        //insert data
        //defining a trans
        //Transaction trans = sess.beginTransaction();
        //sess.persist(s1);
        //trans.commit();

        //read data
        /*Student s2 = sess.find(Student.class,101);
        System.out.println(s2);*/
        //closing session

        //update data -- merge can work like insert/update
        Student s2 = new Student();
        s2.setsName("Kumar");
        s2.setsRollNo(102);
        s2.setsAge(23);
        Transaction trans = sess.beginTransaction();
        sess.merge(s2);
        trans.commit();

        //for delete we have sess.remove(obj);
        sess.close();
        sf.close();
        }
    }
