package com.diogoaltoe.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.config.EnableHypermediaSupport;

import feign.RequestInterceptor;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@EnableFeignClients
@EnableHypermediaSupport(type=EnableHypermediaSupport.HypermediaType.HAL)
@EnableHystrix
@EnableHystrixDashboard
public class ServerGatewayApplication extends SpringBootServletInitializer {
	
	/**
     * Used when run as a JAR
     * @param args
     */
    public static void main(String[] args) {
    	
        SpringApplication.run(ServerGatewayApplication.class, args);
    }
	
	/**
     * Used when run as a WAR
     * @param args
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    	
        return builder.sources(ServerGatewayApplication.class);
    }
	
	@Bean
    public RequestInterceptor getUserFeignClientInterceptor() {
		
        return new UserFeignClientInterceptor();
    }
	
}
