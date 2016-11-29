/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsvier.workshop2.MVC.Model.DAO;

import com.rsvier.workshop2.Interfaces.InterfaceGenericDAO;
import com.rsvier.workshop2.Utilities.Hibernate.HibernateManager;
import java.io.Serializable;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Gavarni
 * @param <Entity>
 * @param <EntityID>
 */
public abstract class GenericDAO<Entity, EntityID extends Serializable> 
        implements InterfaceGenericDAO<Entity, EntityID> {
    
    private Session session;
    private Transaction tx;

    public GenericDAO() {
        HibernateManager.getSessionFactory();
    }
    
    // Generic CRUD Methods
    
    @Override
    public void create(Entity entityRef){
        try {
            startOperation();
            session.saveOrUpdate(entityRef);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            //Hoezo kan non static closeSession niet van een Static context gerefernced worden. closeSession in hibernateManager is non static
            HibernateManager.closeSession(session);
        }
    }
    
    @Override
    public Entity read(EntityID id){
        try {
            startOperation();
            Entity entityRef = session.find(Entity.class, id);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            //Hoezo kan non static closeSession niet van een Static context 
            //gerefernced worden. closeSession in hibernateManager is non static
            HibernateManager.closeSession(session);
        }
            
        return entityRef;
    }

    @Override
    public void update(Entity entityRef){
        try {
            startOperation();
            session.update(entityRef);
        } catch(HibernateException e) {
            handleException(e);
        } finally {
            HibernateManager.closeSession(session);
        }
    }
    
    @Override
    public void delete(Entity entityRef){
        try {
            startOperation();
            session.delete(entityRef);
        } catch(HibernateException e) {
            handleException(e);
        } finally {
            HibernateManager.closeSession(session);
        }
    }
    
    
    
    

    protected void startOperation() throws HibernateException {
        session = HibernateManager.openSession();
        tx = session.beginTransaction();
    }
    
    protected void handleException(HibernateException e) throws DataAccessLayerException {
        HibernateManager.rollback(tx);
        throw new DataAccessLayerException(e);
    }
    
}
