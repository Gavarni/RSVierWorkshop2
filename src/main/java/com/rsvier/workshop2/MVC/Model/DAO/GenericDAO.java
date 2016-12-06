package com.rsvier.workshop2.MVC.Model.DAO;

import com.rsvier.workshop2.Interfaces.InterfaceGenericDAO;
import com.rsvier.workshop2.ORM.Hibernate.HibernateManager;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Autowired
    private HibernateManager hibernate;

    @Override
    public void create(T t) {
        HibernateManager.getSessionFactory().getCurrentSession().saveOrUpdate(t);
    }
    
    @Override
    public T read(K id){
        
     //   return t
    }
    
    
    
}
