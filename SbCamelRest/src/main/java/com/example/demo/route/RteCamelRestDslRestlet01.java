// Description    : 
//                   Tests sur les différents URL possibles. 
// 
//  

package com.example.demo.route;



import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.demo.service.HelloService;


@Component
public class RteCamelRestDslRestlet01 extends RouteBuilder{

	@Value("${poeOrderStock}")
	String port; 

	@Value("${hoeOrderStock}")
	String hostName; 

	@Value ("${componentHttpServer}")
	String componentHttpServer;


	@Autowired 
	HelloService helloService; 
	
	// Creation du nom du fichier. 
	String FileName = ""; 
	// Date du fichier. 
	// header.id 
	// fileSuffix (-articles.txt) parametre 
	//?fileName=test${date:now:yyyyMMdd}.txt&fileExist=Append


	@Override
	public void configure() throws Exception {

		restConfiguration()
		.component("restlet")
		.dataFormatProperty("prettyPrint", "true")
		.contextPath("/myservices")
		.componentProperty("minThreads", "1")
		.componentProperty("maxThreads", "8")
		.host(hostName)
		.port(port)
		;

		rest("/orders")
		.description("User rest service")
		.produces("text/plain")
		.get("/order").to("direct:order")
		.get("/order/{numOrder}").to("direct:orderNum")
		.get("/order/{numOrder}/comments").to("direct:orderNumComments")
		.get("/order/{numOrder}/comments/{numComments}").to("direct:orderNumCommentsNum")
		;

		
		// pour chaque URI je cree une route . 
		from("direct:order")
		.routeId("routeOrder")
		.log(" Route order ") 
		
		.setBody(constant("World "))
		.bean(helloService)            // Premiere syntaxe le bean helloService n'a qu'une methode 
		.to("bean:helloService")       // Deuxieme syntaxe. 
		
		// .to("bean:userService?method=getUser(${header.test},${header.id})")
		
		// Envoi vers un fichier dont le nom est calculé.

		// Calcul du nombre d'articles.
		//.to("xslt:com/acme/mytransform.xsl")
		;

		
		
		//		//{{timer.period}}
		from("timer:hello?period=2000")
		.routeId("appelWsRest")
		.setHeader("id", simple("${random(1,3)}"))
		
		.to("rest:get:myservices/orders/order")
		.log(" Retour appel order : ${body}")
		
//		.to("rest:get:myservices/orders/order/${id}")
//		.log(" Retour appel 02 : ${body}")
//		
//		.to("rest:get:myservices/orders/order/${id}/comments")
//		.log(" Retour appel 03 : ${body}")
//		
//		.to("rest:get:myservices/orders/order/123/comments/${id}")
//		.log(" Retour appel 04 : ${body}")
		
		
		;

	}

	// .description("Find user by id")
	// .outType(Order.class) // ???? 
	//.log("${header.id}")
	//.responseMessage().code(400).message("Test message code 400" )
	// .responseMessage().
	//.endResponseMessage()



}





