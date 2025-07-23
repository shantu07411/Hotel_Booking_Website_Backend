package com.thundercube.TourismApiGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TourismApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(TourismApiGatewayApplication.class, args);
	}

}
