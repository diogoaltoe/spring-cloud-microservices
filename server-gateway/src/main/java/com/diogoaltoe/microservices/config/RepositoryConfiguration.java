package com.diogoaltoe.microservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.diogoaltoe.microservices.repository.UserEventHandler;

@Configuration
public class RepositoryConfiguration {
	
	@Bean
	UserEventHandler userEventHandler() {
		return new UserEventHandler();
	}

}
