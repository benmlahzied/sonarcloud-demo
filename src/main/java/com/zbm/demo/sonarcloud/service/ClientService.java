package com.zbm.demo.sonarcloud.service;

import com.zbm.demo.sonarcloud.domain.Account;
import com.zbm.demo.sonarcloud.domain.ClientInfos;
import com.zbm.demo.sonarcloud.domain.Order;
import com.zbm.demo.sonarcloud.domain.Preferences;
import com.zbm.demo.sonarcloud.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private AccountService accountService;

    private final ToggleService toggleService;
    private final ClientRepository clientRepository;
    private final PreferencesService preferencesService;
    private final LoggingService loggingService;
    private final OrderService orderService;

    public ClientService(AccountService accountService, ToggleService toggleService,
                         ClientRepository clientRepository, PreferencesService preferencesService,
                         LoggingService loggingService, OrderService orderService) {
        this.accountService = accountService;
        this.toggleService = toggleService;
        this.clientRepository = clientRepository;
        this.preferencesService = preferencesService;
        this.loggingService = loggingService;
        this.orderService = orderService;
    }

    public ClientDetails getClientDetails(long clientId) {
        if (toggleService.isOn("read-client-details")) {
            ClientInfos clientInfos = clientRepository.findById(clientId);
            List<Account> accounts = accountService.getClientAccounts(clientId);
            List<Order> orders = orderService.getClientOrders(clientId);
            Preferences preferences = preferencesService.getClientPreferences(clientId);
            loggingService.info("Fetched client details.");
            return new ClientDetails(clientInfos, preferences, accounts, orders);
        } else {
            throw new UnsupportedOperationException("Unsupported");
        }
    }

    private record ClientDetails(ClientInfos clientInfos, Preferences preferences, List<Account> accounts, List<Order> orders) {
    }
}
