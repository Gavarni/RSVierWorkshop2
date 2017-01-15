/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsvier.workshop2.service;

import com.rsvier.workshop2.interfaces.InterfaceGenericService;
import com.rsvier.workshop2.mvc.model.pojo.Adres;
import com.rsvier.workshop2.mvc.model.repository.RepositoryAdres;
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
public class ServiceAdress implements InterfaceGenericService {
    
    @Autowired
    private RepositoryAdres repositoryAdres;

    @Autowired
    public ServiceAdress(RepositoryAdres repositoryAdres){
        this.repositoryAdres = repositoryAdres;
    }
    
    
    @Transactional(propagation=Propagation.REQUIRED, readOnly = true)
    public List<Adres> getAll() {
        //List<Account> accounts = repositoryAccount.findAll();
        //return accounts;
        
        return repositoryAdres.findAll();
    }
    
    
    public Adres get(Long id) {
        Adres adress = repositoryAdres.getOne(id);
        return adress;
    }
    
    
    public Adres create(Adres adress) {
        if (adress.getIdAdres() != null){
            return null;
        }
        Adres savedAdress = repositoryAdres.save(adress);
        return savedAdress;
    }
    
    
    public Adres update(Adres adress) {
        Adres foundAdress = get(adress.getIdAdres());
        if(foundAdress == null){
        return null;
        }
        Adres updatedAdress = repositoryAdres.save(adress);
        return updatedAdress;
    }
    
    
    public void remove(Long id) {
        repositoryAdres.delete(id);;
    }
    
}
