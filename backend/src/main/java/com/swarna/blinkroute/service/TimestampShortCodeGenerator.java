package com.swarna.blinkroute.service;

import org.springframework.stereotype.Component;

@Component 
public class TimestampShortCodeGenerator implements ShortCodeGenerator {
    @Override
    public String generateCode() {
        return String.valueOf(System.currentTimeMillis()).substring(0, 6);
    }

}
