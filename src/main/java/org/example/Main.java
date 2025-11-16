package org.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //config for defining class to be treated as entity
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(org.example.Laptop.class);
        cfg.configure();

        //session to connect to db  per application
        //we have created two session but will hit db once, as we have enabled cache
        SessionFactory sf = cfg.buildSessionFactory();
        Session sess = sf.openSession();

        Laptop laptop = sess.find(Laptop.class,2);

        System.out.println(laptop);
        sess.close();
        Session sess2 = sf.openSession();
        Laptop laptop2 = sess2.find(Laptop.class,2);

        System.out.println(laptop2);
        sess2.close();

        sf.close();
        }
    }
