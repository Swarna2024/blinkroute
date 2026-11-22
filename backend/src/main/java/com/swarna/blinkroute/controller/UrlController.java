package com.swarna.blinkroute.controller;

import com.swarna.blinkroute.dao.UrlDAOImp;
import com.swarna.blinkroute.entity.Url;
import com.swarna.blinkroute.service.ShortCodeGenerator;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class UrlController {
    private final ShortCodeGenerator shortCodeGenerator;
    private final UrlDAOImp urlDAO;

    @Autowired
    public UrlController(ShortCodeGenerator shortCodeGenerator, UrlDAOImp urlDAO) {
        this.shortCodeGenerator = shortCodeGenerator;
        this.urlDAO = urlDAO;
    }

    @GetMapping("/generate")
    public String generateShortCode() {
        return shortCodeGenerator.generateCode();
    }

    @GetMapping("/testing")
    public String createTestData() {

        Url url1 = new Url("http://www.example.com", "abc123", LocalDateTime.now(), LocalDateTime.now(), 1);
        urlDAO.save(url1);

        return new String("Test data created successfully");
    }

}
