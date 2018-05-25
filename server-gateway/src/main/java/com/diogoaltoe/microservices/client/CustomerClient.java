package com.diogoaltoe.microservices.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("SERVICE-RELATIONSHIP")
public interface CustomerClient {

	@RequestMapping(value = "/customer", method = {RequestMethod.GET})
	public String getAll();
	
	@RequestMapping(value = "/customer/{id}", method = {RequestMethod.GET})
	public String getById(@PathVariable("id") Integer id);

	@RequestMapping(value = "/customer", method = {RequestMethod.POST})
	public String post(@RequestBody Customer customer);
	
	@RequestMapping(value = "/customer/{id}", method = {RequestMethod.PUT})
	public String put(@PathVariable("id") Integer id, @RequestBody Customer customer);
	
	@RequestMapping(value = "/customer/{id}", method = {RequestMethod.PATCH})
	public String patch(@PathVariable("id") Integer id, @PathVariable("params") String params);
	
	@RequestMapping(value = "/customer/{id}", method = {RequestMethod.DELETE})
	public String delete(@PathVariable("id") Integer id);
	
}
