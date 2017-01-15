/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsvier.workshop2.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Gavarni
 */
@Controller
public class ControllerAuthentication {
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String viewLogin() {
        return "authentication/login";
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String viewRegister() {
        return "authentication/register";
    }
    
}
