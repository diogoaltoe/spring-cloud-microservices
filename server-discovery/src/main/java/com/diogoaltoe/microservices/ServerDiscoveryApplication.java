package com.diogoaltoe.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServerDiscoveryApplication extends SpringBootServletInitializer {
	
	/**
     * Used when run as a JAR
     * @param args
     */
    public static void main(String[] args) {
    	
        SpringApplication.run(ServerDiscoveryApplication.class, args);
    }
	
	/**
     * Used when run as a WAR
     * @param args
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    	
        return builder.sources(ServerDiscoveryApplication.class);
    }

}
