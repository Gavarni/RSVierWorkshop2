/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsvier.workshop2.service;

import com.rsvier.workshop2.interfaces.InterfaceGenericService;
import com.rsvier.workshop2.mvc.model.pojo.Account;
import com.rsvier.workshop2.mvc.model.pojo.BestellingHasArtikel;
import com.rsvier.workshop2.mvc.model.repository.RepositoryBestellingArtikel;
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
public class ServiceBestellingHasArtikel implements InterfaceGenericService {
    
    @Autowired
    private RepositoryBestellingArtikel repositoryBestellingArtikel;
    
    @Autowired
    public ServiceBestellingHasArtikel(RepositoryBestellingArtikel repositoryBestellingArtikel){
        this.repositoryBestellingArtikel = repositoryBestellingArtikel;
    }
    
    @Transactional(propagation=Propagation.REQUIRED, readOnly = true)
    public List<BestellingHasArtikel> getAll() {
        //List<Account> accounts = repositoryAccount.findAll();
        //return accounts;
        
        return repositoryBestellingArtikel.findAll();
    }
    
    public BestellingHasArtikel get(Long id) {
        BestellingHasArtikel bestellingHasArtikel = repositoryBestellingArtikel.getOne(id);
        return bestellingHasArtikel;
    }
    
    public BestellingHasArtikel create(BestellingHasArtikel bestellingHasArtikel) {
        if (bestellingHasArtikel.getId() != null){
            return null;
        }
        BestellingHasArtikel savedBestellingHasArtikel = repositoryBestellingArtikel.save(bestellingHasArtikel);
        return savedBestellingHasArtikel;
    }
    /*
    public BestellingHasArtikel update(BestellingHasArtikel bestellingHasArtikel) {
        BestellingHasArtikel foundBestellingHasArtikel = get(bestellingHasArtikel.getId());
        if(foundBestellingHasArtikel == null){
            return null;
        }
        BestellingHasArtikel updatedBestellingHasArtikel = repositoryBestellingArtikel.save(bestellingHasArtikel);
        return updatedBestellingHasArtikel;
    }*/
    
    
    public void remove(Long id) {
        repositoryBestellingArtikel.delete(id);;
    }
    
}
