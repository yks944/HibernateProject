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
        SessionFactory sf = cfg.buildSessionFactory();
        Session sess = sf.openSession();
        String brand = "Lenovo";
        Query query = sess.createQuery("select brand, model from Laptop where brand like ?1");
        query.setParameter(1,brand);
        List<Object[]>laptops = query.getResultList();
       // Laptop lap = sess.find(Laptop.class,3);
        for(Object[] data: laptops)
        {
            System.out.println((String)data[0]+" "+data[1]);
        }
        sess.close();
        sf.close();
        }
    }
