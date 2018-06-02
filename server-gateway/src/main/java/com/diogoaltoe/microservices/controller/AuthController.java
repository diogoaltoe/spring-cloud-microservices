package com.diogoaltoe.microservices.controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diogoaltoe.microservices.model.User;
import com.diogoaltoe.microservices.repository.UserRepository;

@RestController
@RequestMapping("/")
public class AuthController {

	@Autowired
	UserRepository userRepository;
	
    @RequestMapping("/user")
    public Principal getCurrentLoggedInUser(Principal user) {
    	
        return user;
    }
    
    @RequestMapping("/user/{username:.*}")
    public User getByUsername(@PathVariable("username") String username) {
    	
    	try {
    		Optional<User> user = userRepository.findByUsername(username);
    	
    		if(user.isPresent()) {
    			
    			return user.get();
    			
    		} else {
    			
    			return null;
    		}
    	} catch (Exception e) {
			// TODO: handle exception
    		
    		return null;
		}
    }
}
