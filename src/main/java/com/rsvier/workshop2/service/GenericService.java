/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsvier.workshop2.service;

import com.rsvier.workshop2.interfaces.InterfaceGenericService;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gavarni
 * @param <E>
 * @param <K>
 */
public abstract class GenericService<E, K> implements InterfaceGenericService<E, K> {
    
    
    //public void saveOrUpdate(E)
    
    
    /*
    @Autowired
    //private GenericRepository<E, K> genericRepository;
    

    public GenericService() {
    }
    
    public GenericService(GenericRepository<E, K> genericRepository) {
        this.genericRepository = genericRepository;
    }
 
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveOrUpdate(E entity) {
        genericRepository.saveOrUpdate(entity);
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<E> getAll() {
        return genericRepository.findAll();
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public E get(K id) {
        return genericRepository.find(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void add(E entity) {
        genericRepository.save(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(E entity) {
        genericRepository.update(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void remove(E entity) {
        genericRepository.delete(entity);
    }
    */
}
