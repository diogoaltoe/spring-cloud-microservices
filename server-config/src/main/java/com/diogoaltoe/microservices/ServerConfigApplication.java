package com.diogoaltoe.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.config.server.EnableConfigServer;


@SpringBootApplication
@EnableConfigServer
public class ServerConfigApplication extends SpringBootServletInitializer {
	
	/**
     * Used when run as a JAR
     * @param args
     */
    public static void main(String[] args) {
    	
        SpringApplication.run(ServerConfigApplication.class, args);
    }
	
	/**
     * Used when run as a WAR
     * @param args
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    	
        return builder.sources(ServerConfigApplication.class);
    }
}
