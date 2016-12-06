package com.rsvier.workshop2.MVC.Model.DAO;

import com.rsvier.workshop2.Interfaces.InterfaceGenericDAO;
import com.rsvier.workshop2.ORM.Hibernate.HibernateManager;
import java.io.Serializable;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Gavarni
 * @param <T>
 * @param <K>
 */
@Repository
@Transactional
public abstract class GenericDAO<T, K extends Serializable> implements InterfaceGenericDAO<T, K>{

    
    private Session session;
    private Transaction tx;

    public GenericDAO() {
        HibernateManager.getSessionFactory();
    }
    
    //CRUD METHODS    
    @Override
    public void create(T t) {
        try { 
            openSessionNow();
            session.saveOrUpdate(t);
            tx.commit();
        }
        catch (HibernateException e) { handleException(e); }
        finally { closeSessionNow(session); }
    }
    
    
    
    
    
    //Session Control
    protected void openSessionNow() throws HibernateException{
        session = HibernateManager.openSession();
         tx = session.beginTransaction();
    }
    
    protected void closeSessionNow(Session session) throws HibernateException{
       if (session != null) {
            try {
                session.close();
            } catch (HibernateException ignored) {
                System.out.print("Couldn't close Session");
                //log.error("Couldn't close Session", ignored);
            }
        }
    }
    
    
    //Error handling
    protected void handleException(HibernateException e) throws DataAccessLayerException {
        rollback(tx);
        throw new DataAccessLayerException(e);
    }
    
    protected void rollback(Transaction tx) {
        try {
            if (tx != null) {
                tx.rollback();
            }
        } catch (HibernateException ignored) {
            System.out.print("Couldn't rollback Transaction");
            //log.error("Couldn't rollback Transaction", ignored);
        }
    }
    
}
