/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsvier.workshop2.Utilities.Hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Gavarni
 */
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
    
    /*
    private static SessionFactory sessionFactory;
        
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            // loads configuration and mappings
            Configuration configuration = new Configuration().configure("ORM/Hibernate/hibernate.cfg.xml");
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            //System.out.println("Connected to Master Database Server");

            
            // builds a session factory from the service registry
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
    return sessionFactory;
    }*/
    //private static 
    

    //BootstrapServiceRegistry bootstrapRegistry = new BootstrapServiceRegistryBuilder().build();
/*
    StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("ORM/Hibernate/hibernate.cfg.xml").build();
    
    public static getSessionFactory(){
        return 
    }
  */
    
    //ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().loadProperties("hibernate-h2.properties").build();
    
    //SessionFactory sessionFactory = new Configuration().configure("ORM/Hibernate/hibernate.cfg.xml").buildSessionFactory();
    //SessionFactory sf = new Configuration().buildSessionFactory(serviceRegistry);
    
    /*
    protected void setUp() throws Exception {
	// A SessionFactory is set up once for an application!
	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
			.configure() // configures settings from hibernate.cfg.xml
			.build();
	try {
		//sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
	}
	catch (Exception e) {
		// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
		// so destroy it manually.
		StandardServiceRegistryBuilder.destroy( registry );
	}
}
*/
//private static SessionFactory SESSION_FACTORY_INSTANCE;


    
    /*
 private static SessionFactory sessionFactory;
     
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            // loads configuration and mappings
            Configuration configuration = new Configuration().configure();
            ServiceRegistry serviceRegistry
                = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
             
            // builds a session factory from the service registry
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);            
        }
         
        return sessionFactory;
    }*/
        
        
        
/*
StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("ORM/Hibernate/hibernate.cfg.xml").build();
Metadata metadata = new MetadataSources(standardRegistry)
    .addAnnotatedClass(Account.class)
    .addAnnotatedClass(Adres.class)
    .addAnnotatedClass(Adrestype.class)
    .addAnnotatedClass(Artikel.class)
    .addAnnotatedClass(Bestelling.class)
    .addAnnotatedClass(BestellingHasArtikel.class)
    .addAnnotatedClass(BestellingHasArtikelId.class)
    .addAnnotatedClass(Klant.class)
    .addAnnotatedClass(KlantHasAdres.class)
    .addAnnotatedClass(KlantHasAdresId.class)
    //.addAnnotatedClassName("com.rsvier.workshop2.MVC.Model.POJO.Account")
    //.addResource("org/hibernate/example/Order.hbm.xml")
    //.addResource("org/hibernate/example/Product.orm.xml")
    .getMetadataBuilder().build();
SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
//Session session = sessionFactory.openSession(); 
    
*/

}
