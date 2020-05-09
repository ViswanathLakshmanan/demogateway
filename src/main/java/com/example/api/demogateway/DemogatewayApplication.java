package com.example.api.demogateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;

@SpringBootApplication
public class DemogatewayApplication {	
	
	public static void main(String[] args) {
		SpringApplication.run(DemogatewayApplication.class, args);
	}
	
	@Bean
	public RouteLocator myRoute(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p
	            .path("/greet")
	            .and()
	            .method(HttpMethod.GET)
	            .filters(f -> f.addRequestHeader("Hello", "World"))
	            .uri("lb://DEMOCLIENT"))	
	    		.build();
	}
	
	
	
}
