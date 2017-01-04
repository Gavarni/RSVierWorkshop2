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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 * @author Gavarni
 */
@Controller
//@RequestMapping("/accounts")
public class ControllerAccount {
    
    @Autowired
    private final RepositoryAccount repositoryAccount;
    
    
    // Moet autowired nou op de constructor of op het declareren hierboven van een repository om de data op te halen En kan het ook een void methode zijn.
    @Autowired
    public ControllerAccount(RepositoryAccount repositoryAccount){
        this.repositoryAccount = repositoryAccount;
    }
        
    // List all Accounts.
    @RequestMapping(value = "/accounts", method=RequestMethod.GET)
    public String listAccounts(Model model) {
        model.addAttribute("accounts", repositoryAccount.findAll());
        System.out.println("Returning accounts:");
        return "account/accounts";
    }
    
    // Show an Account by its ID
    @RequestMapping(value = "account/{id}", method=RequestMethod.GET)
    public String showAccount(@PathVariable Long id, Model model) {
        model.addAttribute("account", repositoryAccount.findOne(id));
        return "account/accountDetails";
    }
    
    // Edit an Account by its ID
    @RequestMapping("account/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("account", repositoryAccount.findOne(id));
        return "account/accountForm";
    }

    // Create new Account
    @RequestMapping("account/create")
    public String newAccount(Model model) {
        model.addAttribute("account", new Account());
        return "account/accountForm";
    }

    // Save Account to DB
    @RequestMapping(value = "account", method = RequestMethod.POST)
    public String saveAccount(Account account) {
        repositoryAccount.save(account);
        return "redirect:/account/" + account.getIdAccount();
    }

    // Delete product by id.
    @RequestMapping("account/delete/{id}")
    public String delete(@PathVariable Long id) {
        repositoryAccount.delete(id);
        return "redirect:/accounts";
    }

}
