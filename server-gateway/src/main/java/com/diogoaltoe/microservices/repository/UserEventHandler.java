package com.diogoaltoe.microservices.repository;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.diogoaltoe.microservices.model.Authority;
import com.diogoaltoe.microservices.model.User;

@RepositoryEventHandler(User.class)
public class UserEventHandler {

	@Autowired
    private AuthorityRepository authorityRepository;
	
	@HandleBeforeCreate
    public void handleBeforeCreate(User user) {
		// Encrypt the password before save
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		
		// Set the User as activated
		user.setActivated(true);
		
		// Instance the Set of authorities
		Set<Authority> authorities = new HashSet<Authority>();
		// Find the Admin Role
		// And add into Set list
		authorities.add(authorityRepository.findByName("ROLE_ADMIN"));
		// Find the User Role
		// And add into Set list
		authorities.add(authorityRepository.findByName("ROLE_USER"));
		// Create the User's authorities 
		user.setAuthorities(authorities);
    }
	
}
