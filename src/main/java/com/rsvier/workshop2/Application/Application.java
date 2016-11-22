/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsvier.workshop2.Application;

import com.rsvier.workshop2.MVC.Model.DAO.DAOAccount;
import com.rsvier.workshop2.MVC.Model.POJO.Account;
import com.rsvier.workshop2.Utilities.Hibernate;
import org.hibernate.Session;

/**
 *
 * @author Gavarni
 */
public class Application {
    
    public static void main (String[] args){
  
        System.out.println("Test step 1");
        Account account = new Account();
        System.out.println("Test step 1 finished");
        
        System.out.println("Test step 2");
        DAOAccount daoAccount = new DAOAccount();
        System.out.println("Test step 2 finished");
        
        System.out.println("Test step 3");
        daoAccount.create(account);

        
    }
    
}

