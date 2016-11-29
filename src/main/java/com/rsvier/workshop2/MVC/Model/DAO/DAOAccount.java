/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsvier.workshop2.MVC.Model.DAO;

import com.rsvier.workshop2.MVC.Model.POJO.Account;
import com.rsvier.workshop2.Utilities.Hibernate.HibernateManager;
import org.hibernate.Session;


/**
 *
 * @author Gavarni
 */
public class DAOAccount extends GenericDAO {
 
        
    public DAOAccount () {
        super();
    }
    
    public void create(Account account) throws DataAccessLayerException {
        super.create(account);
    }
    
    public void update(Account account){
        super.update(account);
    }
    
    public void delete(Account account){
        super.delete(account);
    }
    
   
        
        //Session session = HibernateManager.getSessionFactory().openSession();
        //session.beginTransaction();
        //super.save(account);
        //session.getTransaction().commit();
        //session.close(); 

    public Account read(Long id) {
        super.read(id);
    }

 }

