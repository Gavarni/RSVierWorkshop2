/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsvier.workshop2.service;

import com.rsvier.workshop2.mvc.model.pojo.Account;
import com.rsvier.workshop2.mvc.model.pojo.Bestelling;
import com.rsvier.workshop2.mvc.model.repository.RepositoryBestelling;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Gavarni
 */
@Service
public class ServiceBestelling {
    
    @Autowired
    private RepositoryBestelling repositoryBestelling;
    
    @Autowired
    public ServiceBestelling(RepositoryBestelling repositoryBestelling){
        this.repositoryBestelling = repositoryBestelling;
    }
    
    @Transactional(propagation=Propagation.REQUIRED, readOnly = true)
    public List<Bestelling> getAll() {
        //List<Account> accounts = repositoryAccount.findAll();
        //return accounts;
        
        return repositoryBestelling.findAll();
    }
    
    public Bestelling get(Long id) {
        Bestelling bestelling = repositoryBestelling.getOne(id);
        return bestelling;
    }
    
    public Bestelling create(Bestelling bestelling) {
        if (bestelling.getIdBestelling() != null){
            return null;
        }
        Bestelling savedBestelling = repositoryBestelling.save(bestelling);
        return savedBestelling;
    }
    
    public Bestelling update(Bestelling bestelling) {
        Bestelling foundBestelling = get(bestelling.getIdBestelling());
        if(foundBestelling == null){
            return null;
        }
        Bestelling updatedBestelling = repositoryBestelling.save(bestelling);
        return updatedBestelling;
    }
    
    public void remove(Long id) {
        repositoryBestelling.delete(id);;
    }
}
