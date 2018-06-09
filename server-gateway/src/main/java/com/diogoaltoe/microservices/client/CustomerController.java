package com.diogoaltoe.microservices.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired 
	private CustomerClient customerClient;
	
	@Autowired
	private Environment environment;
	
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAll() {
		
		String response = customerClient.getAll();
		
		if( (response != null) && !response.isEmpty() && (response.length() > 0) ) {
			
			String relationshipHost = environment.getProperty("my.relationship.host");
			String gatewayHost = environment.getProperty("my.gateway.host");
			
			return response.replace(relationshipHost, gatewayHost);
		}

		return response;
	}
	
	@RequestMapping(method = RequestMethod.GET, params = {"sort", "firstName.dir"}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllSort(@RequestParam(value = "sort") String column, @RequestParam(value = "firstName.dir") String sort) {
		
		String response = customerClient.getAllSort(column, sort);
		
		if( (response != null) && !response.isEmpty() && (response.length() > 0) ) {
			
			String relationshipHost = environment.getProperty("my.relationship.host");
			String gatewayHost = environment.getProperty("my.gateway.host");
			
			return response.replace(relationshipHost, gatewayHost);
		}

		return response;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getById(@PathVariable("id") Integer id) {
		
		String response = customerClient.getById(id);
		
		if( (response != null) && !response.isEmpty() && (response.length() > 0) ) {
			
			String relationshipHost = environment.getProperty("my.relationship.host");
			String gatewayHost = environment.getProperty("my.gateway.host");
			
			return response.replace(relationshipHost, gatewayHost);
		}

		return response;
	}
		
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String post(@RequestBody Customer customer) {
		
		String response = customerClient.post(customer);
		
		if( (response != null) && !response.isEmpty() && (response.length() > 0) ) {
			
			String relationshipHost = environment.getProperty("my.relationship.host");
			String gatewayHost = environment.getProperty("my.gateway.host");
			
			return response.replace(relationshipHost, gatewayHost);
		}

		return response;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String put(@PathVariable("id") Integer id, @RequestBody Customer customer) {
		
		String response = customerClient.put(id, customer);
		
		if( (response != null) && !response.isEmpty() && (response.length() > 0) ) {
			
			String relationshipHost = environment.getProperty("my.relationship.host");
			String gatewayHost = environment.getProperty("my.gateway.host");
			
			return response.replace(relationshipHost, gatewayHost);
		}

		return response;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String patch(@PathVariable("id") Integer id, @RequestBody String customer) {
		
		String response = customerClient.patch(id, customer);
		
		if( (response != null) && !response.isEmpty() && (response.length() > 0) ) {
			
			String relationshipHost = environment.getProperty("my.relationship.host");
			String gatewayHost = environment.getProperty("my.gateway.host");
			
			return response.replace(relationshipHost, gatewayHost);
		}

		return response;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<Customer> delete(@PathVariable("id") Integer id) {
		
		/*
		String response = customerClient.delete(id);
		
		if( (response != null) && !response.isEmpty() && (response.length() > 0) ) {
		
			String relationshipHost = environment.getProperty("my.relationship.host");
			String gatewayHost = environment.getProperty("my.gateway.host");
		
			return response.replace(relationshipHost, gatewayHost);
		}

		return response;
		*/
		
		return customerClient.delete(id);
	}
	
}
