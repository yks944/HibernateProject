package org.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
    //Server=localhost;Database=master;Trusted_Connection=True;
        Student s1 = new Student();
        s1.setsName("Yashasvi");
        s1.setsRollNo(101);
        s1.setsAge(25);

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(org.example.Student.class);
        cfg.configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session sess = sf.openSession();

        Transaction trans = sess.beginTransaction();
        sess.persist(s1);
        trans.commit();
        }
    }
