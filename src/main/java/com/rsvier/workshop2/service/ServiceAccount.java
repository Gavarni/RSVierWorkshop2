/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsvier.workshop2.service;

import com.rsvier.workshop2.interfaces.InterfaceGenericService;
import com.rsvier.workshop2.mvc.model.pojo.Account;
import com.rsvier.workshop2.mvc.model.repository.RepositoryAccount;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Gavarni
 */

// Is het slim om een service een abstract class te maken om interface methodes over te nemen. 

@Service
public class ServiceAccount implements InterfaceGenericService {
    
    
    @Autowired
    private RepositoryAccount repositoryAccount;

    @Autowired
    public ServiceAccount(RepositoryAccount repositoryAccount){
        this.repositoryAccount = repositoryAccount;
    }
    
    
    @Transactional(propagation=Propagation.REQUIRED, readOnly = true)
    public List<Account> getAll() {
        //List<Account> accounts = repositoryAccount.findAll();
        //return accounts;
        
        return repositoryAccount.findAll();
    }
    
    
    public Account get(Long id) {
        Account account = repositoryAccount.getOne(id);
        return account;
    }
    
    
    public Account create(Account account) {
        if (account.getIdAccount() != null){
            return null;
        }
        Account savedAccount = repositoryAccount.save(account);
        return savedAccount;
    }
    
    
    public Account update(Account account) {
        Account foundAccount = get(account.getIdAccount());
        if(foundAccount == null){
            return null;
        }
        Account updatedAccount = repositoryAccount.save(account);
        return updatedAccount;
    }
    
    
    public void remove(Long id) {
        repositoryAccount.delete(id);;
    }
    
}
