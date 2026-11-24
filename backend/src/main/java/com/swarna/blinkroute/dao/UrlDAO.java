package com.swarna.blinkroute.dao;

import java.util.List;

import com.swarna.blinkroute.entity.Url;

public interface UrlDAO {
    void save(Url url);

    Url findById(Long id);

    List<Url> findAll();

    void update(Url url);
}
