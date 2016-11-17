/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsvier.workshop2.MVC.Model.POJO;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Gavarni
 */

@Entity
@Table(name = "Account")
public class Account implements Serializable {
    
    private long id;
    private String name;
    
    public Account() {
    }
    
    public Account(String newName) {
	this.name = newName;
    }
    
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idUser", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
        
}
