/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsvier.workshop2.MVC.Model.DAO;

import com.rsvier.workshop2.MVC.Model.POJO.Account;


/**
 *
 * @author Gavarni
 */
public class DAOAccount extends GenericDAO {
 
        
    public DAOAccount () {
        super();
    }
    
    public void create(Account account){
        super.create(account);
    }
    
   
        
        //Session session = HibernateManager.getSessionFactory().openSession();
        //session.beginTransaction();
        //super.save(account);
        //session.getTransaction().commit();
        //session.close(); 
/*
    public Account read(Long id) {
        return (Account) super.read(Account.class, id);
    }*/

 }

