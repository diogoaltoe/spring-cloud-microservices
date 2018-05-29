package com.diogoaltoe.microservices.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired 
	private CustomerClient customerClient;
	
	@Autowired
	private Environment environment;
	
	@RequestMapping(method = RequestMethod.GET)
    public String getAll() {
		
		String relationshipHost = environment.getProperty("my.relationship.host");
		String gatewayHost = environment.getProperty("my.gateway.host");
		
		String response = customerClient.getAll();
		
		if( (response != null) && !response.isEmpty() && (response.length() > 0) ) {
			return response.replace(relationshipHost, gatewayHost);
		}

		return response;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getById(@PathVariable("id") Integer id) {
		
		String relationshipHost = environment.getProperty("my.relationship.host");
		String gatewayHost = environment.getProperty("my.gateway.host");
		
		String response = customerClient.getById(id);
		
		if( (response != null) && !response.isEmpty() && (response.length() > 0) ) {
			return response.replace(relationshipHost, gatewayHost);
		}

		return response;
	}
		
	@RequestMapping(method = RequestMethod.POST)
    public String post(@RequestBody Customer customer) {
		
		String relationshipHost = environment.getProperty("my.relationship.host");
		String gatewayHost = environment.getProperty("my.gateway.host");
		
		String response = customerClient.post(customer);
		
		if( (response != null) && !response.isEmpty() && (response.length() > 0) ) {
			return response.replace(relationshipHost, gatewayHost);
		}

		return response;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String put(@PathVariable("id") Integer id, @RequestBody Customer customer) {
		
		String relationshipHost = environment.getProperty("my.relationship.host");
		String gatewayHost = environment.getProperty("my.gateway.host");
		
		String response = customerClient.put(id, customer);
		
		if( (response != null) && !response.isEmpty() && (response.length() > 0) ) {
			return response.replace(relationshipHost, gatewayHost);
		}

		return response;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public String patch(@PathVariable("id") Integer id, @RequestBody String params) {
		
		String relationshipHost = environment.getProperty("my.relationship.host");
		String gatewayHost = environment.getProperty("my.gateway.host");
		
		String response = customerClient.patch(id, params);
		
		if( (response != null) && !response.isEmpty() && (response.length() > 0) ) {
			return response.replace(relationshipHost, gatewayHost);
		}

		return response;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
		
		String relationshipHost = environment.getProperty("my.relationship.host");
		String gatewayHost = environment.getProperty("my.gateway.host");
		
		String response = customerClient.delete(id);
		
		if( (response != null) && !response.isEmpty() && (response.length() > 0) ) {
			return response.replace(relationshipHost, gatewayHost);
		}

		return response;
	}
	
}
