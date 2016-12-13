/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsvier.workshop2.service;

import com.rsvier.workshop2.mvc.model.repository.RepositoryKlant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gavarni
 */
@Service
public class ServiceKlant {
    
    @Autowired
    private RepositoryKlant repositoryKlant;
    
    
    
}
