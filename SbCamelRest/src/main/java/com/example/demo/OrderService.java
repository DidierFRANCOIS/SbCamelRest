package com.example.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.example.demo.model.Order;




public interface OrderService {
	 
    Order getOrder(int orderId);
 
    void updateOrder(Order order);
 
    String createOrder(Order order);
 
    void cancelOrder(int orderId);
    
    
}