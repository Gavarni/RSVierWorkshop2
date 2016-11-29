/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsvier.workshop2.Interfaces;

import java.io.Serializable;

/**
 *
 * @author Gavarni
 * @param <Entity>
 * @param <EntityID>
 */
public interface InterfaceGenericDAO<Entity, EntityID extends Serializable> {
    
    public void create(Entity entityRef);
    //waarom kan ik niet gewoon de id als enige parameter meegeven
   // public Entity read(EntityID id);
    public void update(Entity entityRef);
    public void delete(Entity entityRef);
    
    //public void readAll();

}
