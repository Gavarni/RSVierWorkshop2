/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsvier.workshop2.MVC.Model.DAO;

import com.rsvier.workshop2.MVC.Model.POJO.Account;
import com.rsvier.workshop2.Utilities.Hibernate;
import org.hibernate.Session;

/**
 *
 * @author Gavarni
 */
public class DAOAccount {

    Session currentSession;
    
    public void create(Account account) {
          
        currentSession = Hibernate.getSessionFactory().openSession();
        currentSession.saveOrUpdate(account);
        
    }    
    
}
