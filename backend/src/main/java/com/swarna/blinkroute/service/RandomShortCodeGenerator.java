package com.swarna.blinkroute.service;

import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
public class RandomShortCodeGenerator implements ShortCodeGenerator {
    @Override
    public String generateCode() {
        return UUID.randomUUID().toString().substring(0, 6);
    }
}
