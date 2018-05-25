package com.diogoaltoe.microservices.client;

import java.net.InetAddress;

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
	
	private String hostPortService = "localhost:9031";
	
	@RequestMapping(method = RequestMethod.GET)
    public String getAll() {
		
		try {
			// Local address
			//String host = InetAddress.getLocalHost().getHostAddress();
			String host = InetAddress.getLocalHost().getHostName();
		    // Remote address
			//String host = InetAddress.getLoopbackAddress().getHostAddress();
			//String host = InetAddress.getLoopbackAddress().getHostName();
		    
			String port = environment.getProperty("local.server.port");
			
			String response = customerClient.getAll();
			
			if(response.length() > 0) {
				return response.replace(hostPortService, host + ":" + port);
			}

			return response;
			
		} catch (Exception e) {
			// TODO: handle exception
			return "ERROR: " + e.getMessage();
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getById(@PathVariable("id") Integer id) {
		
		try {
			// Local address
			//String host = InetAddress.getLocalHost().getHostAddress();
			String host = InetAddress.getLocalHost().getHostName();
		    // Remote address
			//String host = InetAddress.getLoopbackAddress().getHostAddress();
			//String host = InetAddress.getLoopbackAddress().getHostName();
		    
			String port = environment.getProperty("local.server.port");
			
			String response = customerClient.getById(id);
			
			if(response.length() > 0) {
				return response.replace(hostPortService, host + ":" + port);
			}

			return response;
			
		} catch (Exception e) {
			// TODO: handle exception
			return "ERROR: " + e.getMessage();
		}
	}
		
	@RequestMapping(method = RequestMethod.POST)
    public String post(@RequestBody Customer customer) {
		
		try {
			// Local address
			//String host = InetAddress.getLocalHost().getHostAddress();
			String host = InetAddress.getLocalHost().getHostName();
		    // Remote address
			//String host = InetAddress.getLoopbackAddress().getHostAddress();
			//String host = InetAddress.getLoopbackAddress().getHostName();
		    
			String port = environment.getProperty("local.server.port");
			
			String response = customerClient.post(customer);
			
			if(response.length() > 0) {
				return response.replace(hostPortService, host + ":" + port);
			}

			return response;
			
		} catch (Exception e) {
			// TODO: handle exception
			return "ERROR: " + e.getMessage();
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String put(@PathVariable("id") Integer id, @RequestBody Customer customer) {
		
		try {
			// Local address
			//String host = InetAddress.getLocalHost().getHostAddress();
			String host = InetAddress.getLocalHost().getHostName();
		    // Remote address
			//String host = InetAddress.getLoopbackAddress().getHostAddress();
			//String host = InetAddress.getLoopbackAddress().getHostName();
		    
			String port = environment.getProperty("local.server.port");
			
			String response = customerClient.put(id, customer);
			
			if(response.length() > 0) {
				return response.replace(hostPortService, host + ":" + port);
			}

			return response;
			
		} catch (Exception e) {
			// TODO: handle exception
			return "ERROR: " + e.getMessage();
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public String patch(@PathVariable("id") Integer id, @RequestBody String params) {
		
		try {
			// Local address
			//String host = InetAddress.getLocalHost().getHostAddress();
			String host = InetAddress.getLocalHost().getHostName();
		    // Remote address
			//String host = InetAddress.getLoopbackAddress().getHostAddress();
			//String host = InetAddress.getLoopbackAddress().getHostName();
		    
			String port = environment.getProperty("local.server.port");
			
			String response = customerClient.patch(id, params);
			
			if(response.length() > 0) {
				return response.replace(hostPortService, host + ":" + port);
			}

			return response;
			
		} catch (Exception e) {
			// TODO: handle exception
			return "ERROR: " + e.getMessage();
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
		
		try {
			// Local address
			//String host = InetAddress.getLocalHost().getHostAddress();
			String host = InetAddress.getLocalHost().getHostName();
		    // Remote address
			//String host = InetAddress.getLoopbackAddress().getHostAddress();
			//String host = InetAddress.getLoopbackAddress().getHostName();
		    
			String port = environment.getProperty("local.server.port");
			
			String response = customerClient.delete(id);
			
			if(response.length() > 0) {
				return response.replace(hostPortService, host + ":" + port);
			}

			return response;
			
		} catch (Exception e) {
			// TODO: handle exception
			return "ERROR: " + e.getMessage();
		}
	}
	
}
