package com.diogoaltoe.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceStockApplication extends SpringBootServletInitializer {
	
	/**
     * Used when run as a JAR
     * @param args
     */
    public static void main(String[] args) {
    	
        SpringApplication.run(ServiceStockApplication.class, args);
    }
	
	/**
     * Used when run as a WAR
     * @param args
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    	
        return builder.sources(ServiceStockApplication.class);
    }
}
