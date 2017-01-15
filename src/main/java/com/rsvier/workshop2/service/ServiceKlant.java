/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsvier.workshop2.service;

import com.rsvier.workshop2.interfaces.InterfaceGenericService;
import com.rsvier.workshop2.mvc.model.pojo.Account;
import com.rsvier.workshop2.mvc.model.pojo.Klant;
import com.rsvier.workshop2.mvc.model.repository.RepositoryAccount;
import com.rsvier.workshop2.mvc.model.repository.RepositoryKlant;
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
public class ServiceKlant implements InterfaceGenericService{
    
    @Autowired
    private RepositoryKlant repositoryKlant;
    
    @Autowired
    public ServiceKlant(RepositoryKlant repositoryKlant){
        this.repositoryKlant = repositoryKlant;
    }
    
    @Transactional(propagation=Propagation.REQUIRED, readOnly = true)
    public List<Klant> getAll() {
        //List<Account> accounts = repositoryAccount.findAll();
        //return accounts;
        
        return repositoryKlant.findAll();
    }
    
    
    public Klant get(Long id) {
        Klant klant = repositoryKlant.getOne(id);
        return klant;
    }
    
    
    public Klant create(Klant klant) {
        if (klant.getIdKlant() != null){
            return null;
        }
        Klant savedAccount = repositoryKlant.save(klant);
        return savedAccount;
    }
    
    
    public Klant update(Klant klant) {
        Klant foundKlant = get(klant.getIdKlant());
        if(foundKlant == null){
            return null;
        }
        Klant updatedAccount = repositoryKlant.save(klant);
        return updatedAccount;
    }
    
    
    public void remove(Long id) {
        repositoryKlant.delete(id);;
    }
    
}
