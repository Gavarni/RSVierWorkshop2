/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsvier.workshop2.MVC.Controller;

import com.rsvier.workshop2.MVC.Model.POJO.Artikel;
import com.rsvier.workshop2.Services.ServiceArtikel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Gavarni
 */
@Controller
@RequestMapping("/Artikelen")
public class ControllerArtikel {
    
    @Autowired
    private ServiceArtikel serviceArtikel;
    /*
    @RequestMapping(method=RequestMapping.GET)
    public List<Artikel> readAll(){
        return serviceArtikel.readAll();
    }*/
    
    @RequestMapping("/Artikelen/kazen/")
    public String ShowKazen() {
        return "artikelen";
    }
    
}
