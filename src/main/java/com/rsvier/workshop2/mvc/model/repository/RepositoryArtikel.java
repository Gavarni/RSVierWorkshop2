/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsvier.workshop2.mvc.model.repository;

import com.rsvier.workshop2.mvc.model.pojo.Artikel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Gavarni
 */
@Repository
public interface RepositoryArtikel extends JpaRepository<Artikel, Long>{
    
}