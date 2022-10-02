package com.zbm.demo.sonarcloud.service;

import com.zbm.demo.sonarcloud.domain.Order;
import com.zbm.demo.sonarcloud.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getClientOrders(long clientId) {
        return orderRepository.findOrdersByClientId(clientId);
    }
}
