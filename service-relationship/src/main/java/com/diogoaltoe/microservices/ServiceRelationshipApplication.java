package com.diogoaltoe.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceRelationshipApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRelationshipApplication.class, args);
	}
}