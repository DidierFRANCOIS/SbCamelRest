package com.example.demo.service;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Component
public class MyProcessorBean {
    public void processExchange(Exchange exchange) {
        // Do whatever you like to 'exchange'...
        exchange.getIn().setBody("Here is a new message body!");
    }
}