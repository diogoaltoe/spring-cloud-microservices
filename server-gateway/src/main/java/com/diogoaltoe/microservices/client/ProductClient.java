package com.diogoaltoe.microservices.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("MICROSERVICE-STOCK")
public interface ProductClient {

	@RequestMapping(value = "/product", method = {RequestMethod.GET})
	public Resources<Object> getAll();
	
	@RequestMapping(value = "/product/{id}", method = {RequestMethod.GET})
	public String getById(@PathVariable("id") Integer id);

	@RequestMapping(value = "/product", method = {RequestMethod.POST})
	public Resources<Object> post(@RequestBody Product product);
	
	@RequestMapping(value = "/product/{id}", method = {RequestMethod.PUT})
	public Resources<Object> put(@PathVariable("id") Integer id, @RequestBody Product product);
	
	@RequestMapping(value = "/product/{id}", method = {RequestMethod.PATCH})
	public Resources<Object> patch(@PathVariable("id") Integer id, @PathVariable("params") String params);
	
	@RequestMapping(value = "/product/{id}", method = {RequestMethod.DELETE})
	public Resources<Object> delete(@PathVariable("id") Integer id);
	
}
