// Description    : 
//                   Tests sur les différents URL possibles. 
//                   Reprise des erreurs. 
//  

package com.example.demo.route;



import org.apache.camel.builder.RouteBuilder;

import org.apache.camel.model.rest.RestBindingMode;
//import org.apache.camel.spi.RestConfiguration.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.example.demo.model.OrderXML;
import com.example.demo.model.RequestDIBBuild;
import com.example.demo.service.BuildDIP;
import com.example.demo.service.HelloService;



@Component
public class RteCamelRestDslRestlet01 extends RouteBuilder{


	@Override
	public void configure() throws Exception {

		
		
		restConfiguration()
		//.bindingMode(RestBindingMode.json)
		.dataFormatProperty("prettyPrint", "true")
		.host("localhost")
		;

		rest("/search")
		.description("User rest service")
		.produces("text/plain")
		//.get("/buildDip/{repInput}/{repOutput}").to("direct:rteBuildDip")
		.get("/getBooking/{codeSite}").to("direct:getBooking")
		.get("/action/test/{repOutput}").to("direct:test")
		
		// .post().type(RequestDIBBuild.class).to("bean:helloService?method=hello") 
		
		//.to("direct:rteBuildDip")
		;
		
		
		from("direct:test")
		.setBody(simple("test parametre :   ${header.repOutput} "));

		from("direct:getBooking")
		.setBody(simple("Disponibilite pour le site :   ${header.codeSite} "));
		
		
		// pour chaque URI je cree une route . 
		from("direct:rteBuildDip")
		.routeId("rteBuildDip")
		.log(" Route build DIP ") 
		.setBody(simple("Parametre retour  ${header} ")) // simple evalue , constant prend la chaine de caractere tel quel 
		;

	
		
		
		
		
		// -------------------
		// lancement du timer. 
		// -------------------
//		from("timer:hello?period=10000")
//		.routeId("appelWsRest")
//		.setHeader("id", simple("${random(1,4)}"))
//		.log(" Identifiant : ${header.id}")
//		
//		.to("rest:get:myservices/orders/order")
//		.log(" Retour appel order : ${body}")
//		
//		.toD("rest:get:myservices/orders/order/${header.id}")
//		.log(" Retour appel 02 : ${body}")
//		
//		.toD("rest:get:myservices/orders/order/${header.id}/comments")
//		.log(" Retour appel 03 : ${body}")
		
//		.toD("rest:get:myservices/orders/order/123/comments/${header.id}")
//		.log(" Retour appel 04 : ${body}")
		

	}

	// .description("Find user by id")
	// .outType(Order.class) // ???? 
	//.log("${header.id}")
	//.responseMessage().code(400).message("Test message code 400" )
	// .responseMessage().
	//.endResponseMessage()

	
	// .to("bean:userService?method=getUser(${header.test},${header.id})")
	// Envoi vers un fichier dont le nom est calculé.

	// Calcul du nombre d'articles.
	//.to("xslt:com/acme/mytransform.xsl")
	
	
	


}





