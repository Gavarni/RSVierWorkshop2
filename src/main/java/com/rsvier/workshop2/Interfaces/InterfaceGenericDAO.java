/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsvier.workshop2.Interfaces;

/**
 *
 * @author Gavarni
 * @param <T>
 * @param <K>
 */
public interface InterfaceGenericDAO<T, K> {
    
    public void create(T t);
    public T read(K id);
    
}
