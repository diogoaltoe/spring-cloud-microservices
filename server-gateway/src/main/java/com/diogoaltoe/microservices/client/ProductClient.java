package com.diogoaltoe.microservices.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("SERVICE-STOCK")
public interface ProductClient {

	@RequestMapping(value = "/product", method = {RequestMethod.GET})
	public String getAll();
	
	@RequestMapping(value = "/product/{id}", method = {RequestMethod.GET})
	public String getById(@PathVariable("id") Integer id);

	@RequestMapping(value = "/product", method = {RequestMethod.POST})
	public String post(@RequestBody Product product);
	
	@RequestMapping(value = "/product/{id}", method = {RequestMethod.PUT})
	public String put(@PathVariable("id") Integer id, @RequestBody Product product);
	
	@RequestMapping(value = "/product/{id}", method = {RequestMethod.PATCH})
	public String patch(@PathVariable("id") Integer id, @PathVariable("params") String params);
	
	@RequestMapping(value = "/product/{id}", method = {RequestMethod.DELETE})
	public String delete(@PathVariable("id") Integer id);
	
}
