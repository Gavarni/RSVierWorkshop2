package com.rsvier.workshop2.mvc.model.repository;

import com.rsvier.workshop2.mvc.model.pojo.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Gavarni
 */
@Repository
@Transactional
public interface RepositoryAccount extends JpaRepository<Account, Long>{
    
}
