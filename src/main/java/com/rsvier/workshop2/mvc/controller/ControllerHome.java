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
public class ControllerHome {
    /*
    @RequestMapping("/")
    public String home(){
        return "index";
    }
    
    
    @RequestMapping(value = "/login", method=RequestMethod.GET)
    public String login(){
        return "app/login";
    }
    */
        
        @RequestMapping(value = "/welcome", method = RequestMethod.GET)
        public String welcome() {
            return "welcome";
        }
        
        @RequestMapping(value = "/greeting", method = RequestMethod.GET)
        public String greeting() {
            return "greeting";
        }
        
        /*
	@Value("${application.message:Hello World}")
	private String message = "Hello World";



	@GetMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", this.message);
		return "welcome";
	}
        
     

	@RequestMapping("/foo")
	public String foo(Map<String, Object> model) {
		throw new RuntimeException("Foo");
	}
        */
}
