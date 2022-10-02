package com.zbm.demo.sonarcloud.service;

import org.springframework.stereotype.Service;

@Service
public class LoggingService {

    public void info(String log) {
        System.out.println(log);
    }
}
