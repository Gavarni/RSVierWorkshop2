/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsvier.workshop2.mvc.controller;

import org.springframework.stereotype.Controller;

/**
 *
 * @author Gavarni
 */
@Controller
public class ControllerProduct {
    
    @Autowired
    private final ServiceProduct serviceProduct;
    
    
    // Moet autowired nou op de constructor of op het declareren hierboven van een repository om de data op te halen En kan het ook een void methode zijn.
    @Autowired
    public ControllerAccount(ServiceAccount serviceAccount){
        this.serviceProduct = serviceProduct;
    }
    
}
