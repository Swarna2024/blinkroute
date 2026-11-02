package com.swarna.blinkroute.controller;

import com.swarna.blinkroute.service.ShortCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlController {
    private final ShortCodeGenerator shortCodeGenerator;

    @Autowired
    public UrlController(ShortCodeGenerator shortCodeGenerator) {
        this.shortCodeGenerator = shortCodeGenerator;
    }

    @GetMapping("/generate")
    public String generateShortCode() {
        return shortCodeGenerator.generateCode();
    }
}
