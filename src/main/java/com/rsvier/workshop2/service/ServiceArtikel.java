/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsvier.workshop2.service;

import com.rsvier.workshop2.interfaces.InterfaceGenericService;
import com.rsvier.workshop2.mvc.model.pojo.Artikel;
import com.rsvier.workshop2.mvc.model.repository.RepositoryArtikel;
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
public class ServiceArtikel implements InterfaceGenericService {
    
    @Autowired
    private RepositoryArtikel repositoryArtikel;
            
    @Autowired
    public ServiceArtikel (RepositoryArtikel repositoryArtikel){
        this.repositoryArtikel = repositoryArtikel;
    }
    
    @Transactional(propagation=Propagation.REQUIRED, readOnly = true)
    public List<Artikel> getAll() {
        //List<Account> accounts = repositoryAccount.findAll();
        //return accounts;
        
        return repositoryArtikel.findAll();
    }
    
    public Artikel get(Long id) {
        Artikel artikel = repositoryArtikel.getOne(id);
        return artikel;
    }
    
    
    public Artikel create(Artikel artikel) {
        if (artikel.getIdArtikel() != null){
            return null;
        }
        Artikel savedArtikel = repositoryArtikel.save(artikel);
        return savedArtikel;
    }
    
    
    public Artikel update(Artikel artikel) {
        Artikel foundArtikel = get(artikel.getIdArtikel());
        if(foundArtikel == null){
            return null;
        }
        Artikel updatedArtikel = repositoryArtikel.save(artikel);
        return updatedArtikel;
    }
    
    
    public void remove(Long id) {
        repositoryArtikel.delete(id);;
    }
    
}
