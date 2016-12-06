/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsvier.workshop2.ORM.Hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Gavarni
 */
@Repository
@Transactional
public class HibernateManager {
    
    private static SessionFactory sessionFactory;
    
    /*  Standaard manier van Hibernate om een SessionFactory aan te maken zonder het gezeur van een Mapping. 
        Mapping word afgehandeld door de MetaDataSourcesbuilder
    */
    public static SessionFactory getSessionFactory() {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("ORM/Hibernate/hibernate.cfg.xml") // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
        }
        return sessionFactory;
    }
    
    
    //Hibernate Session Management
    public static Session openSession() throws HibernateException {
        return sessionFactory.openSession();
    }
    
    public static void closeSession(Session session) throws HibernateException {
        if (session != null) {
            try {
                session.close();
            } catch (HibernateException ignored) {
                System.out.print("Couldn't close Session");
                //log.error("Couldn't close Session", ignored);
            }
        }
    }
    
    public static void rollback(Transaction tx) {
        try {
            if (tx != null) {
                tx.rollback();
            }
        } catch (HibernateException ignored) {
            System.out.print("Couldn't rollback Transaction");
            //log.error("Couldn't rollback Transaction", ignored);
        }
    }
    
}

