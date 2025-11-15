package org.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
    //Server=localhost;Database=master;Trusted_Connection=True;
//        Student s1 = new Student();
//        s1.setsName("Kumar");
//        s1.setsRollNo(102);
//        s1.setsAge(25);
        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setRam(16);
        l1.setBrand("Asus");
        l1.setModel("Rog");

        Laptop l2 = new Laptop();
        l2.setLid(2);
        l2.setRam(16);
        l2.setBrand("Dell");
        l2.setModel("Xps");
        Alien a1 = new Alien();
        a1.setAid(101);
        a1.setAname("Yash");
        a1.setTech("Java");
        a1.setLaptops(Arrays.asList(l1,l2));

        l1.setAlien(a1);
        l2.setAlien(a1);
        //config for defining class to be treated as entity
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(org.example.Alien.class).addAnnotatedClass(org.example.Laptop.class);
        cfg.configure();

        //session to connect to db  per application
        SessionFactory sf = cfg.buildSessionFactory();
        Session sess = sf.openSession();

        Transaction trans = sess.beginTransaction();
        sess.persist(l1);
        sess.persist(l2);
        sess.persist(a1);
        trans.commit();
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
//        Student s2 = new Student();
//        s2.setsName("Kumar");
//        s2.setsRollNo(102);
//        s2.setsAge(23);
//        Transaction trans = sess.beginTransaction();
//        sess.merge(s2);
//        trans.commit();

        //for delete we have sess.remove(obj);
        sess.close();
        sf.close();
        }
    }
