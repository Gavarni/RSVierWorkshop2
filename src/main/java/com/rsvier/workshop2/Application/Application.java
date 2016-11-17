/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsvier.workshop2.Application;

import com.rsvier.workshop2.MVC.Model.POJO.Account;
import com.rsvier.workshop2.Utilities.Hibernate;
import org.hibernate.Session;

/**
 *
 * @author Gavarni
 */
public class Application {
    
    public static void main (String[] args){
        
        System.out.println("Maven + Hibernate + MySQL");
        Session session = Hibernate.getSessionFactory().openSession();

        session.beginTransaction();
        Account Account = new Account();

        Account.setName("Test");

        session.save(Account);
        session.getTransaction().commit();
        
    }
    
}

