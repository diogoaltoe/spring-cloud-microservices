package com.diogoaltoe.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RestController;

import com.diogoaltoe.microservices.client.Product;
import com.diogoaltoe.microservices.client.ProductClient;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired 
	private ProductClient productClient;
	
	@RequestMapping(method = RequestMethod.GET)
    public Resources<Object> getAll() {
		
		return productClient.getAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getById(@PathVariable("id") Integer id) {
		
		return productClient.getById(id);
	}
		
	@RequestMapping(method = RequestMethod.POST)
    public Resources<Object> post(@RequestBody Product product) {
		
        return productClient.post(product);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Resources<Object> put(@PathVariable("id") Integer id, @RequestBody Product product) {
		
        return productClient.put(id, product);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public Resources<Object> patch(@PathVariable("id") Integer id, @RequestBody String params) {
		
        return productClient.patch(id, params);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Resources<Object> delete(@PathVariable("id") Integer id) {
		
        return productClient.delete(id);
	}
	
}
