/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsvier.workshop2.MVC.Controller;

import com.rsvier.workshop2.MVC.Model.POJO.Account;
import com.rsvier.workshop2.Services.ServiceAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Gavarni
 */
@RestController
@RequestMapping("/accounts")
public class ControllerAccount {
    
    @Autowired
    private ServiceAccount serviceAccount;
    
    
}
