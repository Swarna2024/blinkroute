package com.swarna.blinkroute.dao;

import org.springframework.stereotype.Repository;

import com.swarna.blinkroute.entity.Url;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class UrlDAOImp implements UrlDAO {

    // define field for EntityManager
    private final EntityManager entityManager;

    // set up constructor injection
    public UrlDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional 
    public void save(Url url) {
        entityManager.persist(url);
    }

}
