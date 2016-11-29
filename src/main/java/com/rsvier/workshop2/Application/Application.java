/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsvier.workshop2.Application;

import com.rsvier.workshop2.MVC.Model.DAO.DAOAccount;
import com.rsvier.workshop2.MVC.Model.POJO.Account;


/**
 *
 * @author Gavarni
 */
public class Application {
    
    public static void main (String[] args){
  
        Account account = new Account();

        account.setNaam("GenericDAO works wtf");
        
        DAOAccount daoAccount = new DAOAccount();
        
        daoAccount.create(account);
        
        account.setIdAccount(4L);
        daoAccount.delete(account);
        
    }
    
}

