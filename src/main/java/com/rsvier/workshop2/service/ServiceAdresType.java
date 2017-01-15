/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsvier.workshop2.service;

import com.rsvier.workshop2.interfaces.InterfaceGenericService;
import com.rsvier.workshop2.mvc.model.pojo.Adrestype;
import com.rsvier.workshop2.mvc.model.repository.RepositoryAdresType;
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
public class ServiceAdresType implements InterfaceGenericService {
    
    @Autowired
    private RepositoryAdresType repositoryAdresType;
    
    @Autowired
    public ServiceAdresType(RepositoryAdresType repositoryAdresType){
        this.repositoryAdresType = repositoryAdresType;
    }
    
    @Transactional(propagation=Propagation.REQUIRED, readOnly = true)
    public List<Adrestype> getAll() {
        //List<Account> accounts = repositoryAccount.findAll();
        //return accounts;
        
        return repositoryAdresType.findAll();
    }
    
    
    public Adrestype get(Long id) {
        Adrestype adrestype = repositoryAdresType.getOne(id);
        return adrestype;
    }
    
    
    public Adrestype create(Adrestype adrestype) {
        if (adrestype.getIdAdresType() != null){
            return null;
        }
        Adrestype savedAdrestype = repositoryAdresType.save(adrestype);
        return savedAdrestype;
    }
    
    
    public Adrestype update(Adrestype adrestype) {
        Adrestype foundAdrestype = get(adrestype.getIdAdresType());
        if(foundAdrestype == null){
        return null;
        }
        Adrestype updatedAdrestype = repositoryAdresType.save(adrestype);
        return updatedAdrestype;
    }
    
    
    public void remove(Long id) {
        repositoryAdresType.delete(id);;
    }
    
}
