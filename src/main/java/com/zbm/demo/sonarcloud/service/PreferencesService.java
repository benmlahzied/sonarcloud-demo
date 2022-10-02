package com.zbm.demo.sonarcloud.service;

import com.zbm.demo.sonarcloud.domain.Preferences;
import org.springframework.stereotype.Service;

@Service
public class PreferencesService {
    public Preferences getClientPreferences(long clientId) {
        return new Preferences();
    }
}
