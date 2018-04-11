package com.example.demo.route;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.example.demo.model.Order;
import com.example.demo.model.RequestDIBBuild;
import com.fasterxml.jackson.core.JsonParseException;

//@Component
public class OrderRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		// Exceptions sur erreur de format json
		onException(JsonParseException.class)
		.handled(true)
		.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(400))
		.setHeader(Exchange.CONTENT_TYPE, constant("text/plain"))
		.setBody().constant("Invalid json data");


		// Gestion de l'action de de l'appel de creation 
		rest("/action")
		.post("/processor")
		.type(RequestDIBBuild.class).to("bean:buildDIP?method=readRequest") 

		;

		
		
		

	}
}