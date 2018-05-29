package com.diogoaltoe.microservices.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired 
	private ProductClient productClient;
	
	@Autowired
	private Environment environment;
	
	@RequestMapping(method = RequestMethod.GET)
	//@HystrixCommand(fallbackMethod="getFallbackGetAll")
    public String getAll() {
		
		String stockHost = environment.getProperty("my.stock.host");
		String gatewayHost = environment.getProperty("my.gateway.host");
		
		String response = productClient.getAll();
		
		if( (response != null) && !response.isEmpty() && (response.length() > 0) ) {
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
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getById(@PathVariable("id") Integer id) {
		
		String stockHost = environment.getProperty("my.stock.host");
		String gatewayHost = environment.getProperty("my.gateway.host");
		
		String response = productClient.getById(id);
		
		if( (response != null) && !response.isEmpty() && (response.length() > 0) ) {
			return response.replace(stockHost, gatewayHost);
		}

		return response;
	}
		
	@RequestMapping(method = RequestMethod.POST)
    public String post(@RequestBody Product product) {
		
		String stockHost = environment.getProperty("my.stock.host");
		String gatewayHost = environment.getProperty("my.gateway.host");
		
		String response = productClient.post(product);
		
		if( (response != null) && !response.isEmpty() && (response.length() > 0) ) {
			return response.replace(stockHost, gatewayHost);
		}

		return response;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String put(@PathVariable("id") Integer id, @RequestBody Product product) {
		
		String stockHost = environment.getProperty("my.stock.host");
		String gatewayHost = environment.getProperty("my.gateway.host");
		
		String response = productClient.put(id, product);
		
		if( (response != null) && !response.isEmpty() && (response.length() > 0) ) {
			return response.replace(stockHost, gatewayHost);
		}

		return response;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	//@HystrixCommand(fallbackMethod="getFallbackPatch")
    public String patch(@PathVariable("id") Integer id, @RequestBody String params) {
		
		String stockHost = environment.getProperty("my.stock.host");
		String gatewayHost = environment.getProperty("my.gateway.host");
		
		String response = productClient.patch(id, params);
		
		if( (response != null) && !response.isEmpty() && (response.length() > 0) ) {
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
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
		
		String stockHost = environment.getProperty("my.stock.host");
		String gatewayHost = environment.getProperty("my.gateway.host");
		
		String response = productClient.delete(id);
		
		if( (response != null) && !response.isEmpty() && (response.length() > 0) ) {
			return response.replace(stockHost, gatewayHost);
		}

		return response;
	}
	
}
