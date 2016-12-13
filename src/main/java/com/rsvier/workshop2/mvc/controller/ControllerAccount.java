/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsvier.workshop2.mvc.controller;

import com.rsvier.workshop2.mvc.model.pojo.Account;
import com.rsvier.workshop2.mvc.model.repository.RepositoryAccount;
import com.rsvier.workshop2.service.ServiceAccount;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//@Autowired
    //private final ServiceAccount serviceAccount;
/**
 *
 * @author Gavarni
 */
@Controller
@RequestMapping("/accounts")
public class ControllerAccount {
    
    @Autowired
    private final RepositoryAccount repositoryAccount;
    
    @Autowired
    public ControllerAccount(RepositoryAccount repositoryAccount){
        this.repositoryAccount = repositoryAccount;
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public String listAccounts(Model model) {
        model.addAttribute("accounts", repositoryAccount.findAll());
        return "accountList";
    }

}
