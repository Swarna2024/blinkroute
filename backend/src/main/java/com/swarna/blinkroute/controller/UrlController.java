package com.swarna.blinkroute.controller;

import com.swarna.blinkroute.dao.UrlDAOImp;
import com.swarna.blinkroute.entity.Url;
import com.swarna.blinkroute.service.ShortCodeGenerator;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

        Url url1 = new Url("http://www.google.com", "xyz123", LocalDateTime.now(), LocalDateTime.now(), 1);
        urlDAO.save(url1);

        return new String("Test data created successfully");
    }

    @GetMapping("/getUrl/{id}")
    public String getUrl(@PathVariable Long id) {
        Url url = urlDAO.findById(id);
        return url.toString();
    }

    @GetMapping("/getAllUrls")
    public String getAllUrls() {
        List<Url> urls = urlDAO.findAll();
        StringBuilder result = new StringBuilder();
        for (Url url : urls) {
            result.append(url.toString()).append("\n");
        }
        return result.toString();
    }

    @GetMapping("/updateExpiryDate")
    public String updateExpiryDate() {

        Url url = urlDAO.findById(1L);
        url.setExpiresAt(LocalDateTime.now().plusDays(30));
        urlDAO.update(url);
        return new String("Expiry date updated successfully");
    }

}
