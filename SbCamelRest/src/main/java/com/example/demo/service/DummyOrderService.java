package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

import com.example.demo.OrderService;
import com.example.demo.model.Order;
import com.example.demo.model.OrderXML;

@Component("orderService")
public class DummyOrderService implements OrderService {

    // in memory dummy order system
    private Map<Integer, Order> orders = new HashMap<>();

    private final AtomicInteger idGen = new AtomicInteger();

    @Override
    public Order getOrder(int orderId) {
        return orders.get(orderId);
    }

    @Override
    public void updateOrder(Order order) {
        int id = order.getId();
        orders.remove(id);
        orders.put(id, order);
    }

    @Override
    public String createOrder(Order order) {
        int id = idGen.incrementAndGet();
        order.setId(id);
        orders.put(id, order);
        return "" + id;
    }

    @Override
    public void cancelOrder(int orderId) {
        orders.remove(orderId);
    }
}