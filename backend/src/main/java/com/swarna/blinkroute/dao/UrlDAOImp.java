package com.swarna.blinkroute.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.swarna.blinkroute.entity.Url;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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

    @Override
    @Transactional
    public Url findById(Long id) {
        return entityManager.find(Url.class, id);
    }

    @Override
    public List<Url> findAll() {
        TypedQuery<Url> query = entityManager.createQuery("SELECT u FROM Url u", Url.class);
        return query.getResultList();
    }

}
