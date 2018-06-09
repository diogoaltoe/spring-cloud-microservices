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
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired 
	private ProductClient productClient;
	
	@Autowired
	private Environment environment;
	
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	//@HystrixCommand(fallbackMethod="getFallbackGetAll")
    public String getAll() {
		
		String response = productClient.getAll();
		
		if( (response != null) && !response.isEmpty() && (response.length() > 0) ) {
			
			String stockHost = environment.getProperty("my.stock.host");
			String gatewayHost = environment.getProperty("my.gateway.host");
			
			return response.replace(stockHost, gatewayHost);
		}

		return response;
			
	}
	
	@RequestMapping(method = RequestMethod.GET, params = {"sort", "name.dir"}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllSort(@RequestParam(value = "sort") String column, @RequestParam(value = "name.dir") String sort) {
		
		String response = productClient.getAllSort(column, sort);
		
		if( (response != null) && !response.isEmpty() && (response.length() > 0) ) {
			
			String stockHost = environment.getProperty("my.stock.host");
			String gatewayHost = environment.getProperty("my.gateway.host");
			
			return response.replace(stockHost, gatewayHost);
		}

		return response;
			
	}
	
	/*public String getFallbackGetAll(Throwable e) {
		
		assert "getFallbackGetAll command failed".equals(e.getMessage());
		
		Object element[] = { "Fora do Ar" };
		Iterable<Object> iterable = Arrays.asList(element);
		String content = new String(iterable);
		
		return content;
		
	}*/
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getById(@PathVariable("id") Integer id) {
		
		String response = productClient.getById(id);
		
		if( (response != null) && !response.isEmpty() && (response.length() > 0) ) {
			
			String stockHost = environment.getProperty("my.stock.host");
			String gatewayHost = environment.getProperty("my.gateway.host");
			
			return response.replace(stockHost, gatewayHost);
		}

		return response;
	}
		
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String post(@RequestBody Product product) {
		
		String response = productClient.post(product);
		
		if( (response != null) && !response.isEmpty() && (response.length() > 0) ) {
			
			String stockHost = environment.getProperty("my.stock.host");
			String gatewayHost = environment.getProperty("my.gateway.host");
			
			return response.replace(stockHost, gatewayHost);
		}

		return response;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String put(@PathVariable("id") Integer id, @RequestBody Product product) {
		
		String response = productClient.put(id, product);
		
		if( (response != null) && !response.isEmpty() && (response.length() > 0) ) {
			
			String stockHost = environment.getProperty("my.stock.host");
			String gatewayHost = environment.getProperty("my.gateway.host");
			
			return response.replace(stockHost, gatewayHost);
		}

		return response;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	//@HystrixCommand(fallbackMethod="getFallbackPatch")
    public String patch(@PathVariable("id") Integer id, @RequestBody String product) {
		
		String response = productClient.patch(id, product);
		
		if( (response != null) && !response.isEmpty() && (response.length() > 0) ) {
			
			String stockHost = environment.getProperty("my.stock.host");
			String gatewayHost = environment.getProperty("my.gateway.host");
			
			return response.replace(stockHost, gatewayHost);
		}

		return response;
	}
	
	/*public String getFallbackPatch() {

		Object element[] = { "Fora do Ar" };
		Iterable<Object> iterable = Arrays.asList(element);
		String content = new String(iterable);
		
		return content;
	}*/
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<Product> delete(@PathVariable("id") Integer id) {
		/*
		String response = productClient.delete(id);
		
		if( (response != null) && !response.isEmpty() && (response.length() > 0) ) {
			
			String stockHost = environment.getProperty("my.stock.host");
			String gatewayHost = environment.getProperty("my.gateway.host");
			
			return response.replace(stockHost, gatewayHost);
		}

		return response;
		*/
		return productClient.delete(id);
	}
	
}
