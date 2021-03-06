package com.diogoaltoe.microservices.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="SERVICE-RELATIONSHIP", url="${my.relationship.host}")
public interface CustomerClient {

	@RequestMapping(value = "/customer", method = {RequestMethod.GET}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getAll();
	
	@RequestMapping(value = "/customer", method = {RequestMethod.GET}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getAllSort(@RequestParam(value = "sort") String column, @RequestParam(value = "firstName.dir") String sort);
	
	@RequestMapping(value = "/customer/{id}", method = {RequestMethod.GET}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getById(@PathVariable("id") Integer id);

	@RequestMapping(value = "/customer", method = {RequestMethod.POST}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String post(@RequestBody Customer customer);
	
	@RequestMapping(value = "/customer/{id}", method = {RequestMethod.PUT}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String put(@PathVariable("id") Integer id, @RequestBody Customer customer);
	
	@RequestMapping(value = "/customer/{id}", method = {RequestMethod.PATCH}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String patch(@PathVariable("id") Integer id, @RequestBody String customer);
	
	@RequestMapping(value = "/customer/{id}", method = {RequestMethod.DELETE}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Resource<Customer> delete(@PathVariable("id") Integer id);
	
}
