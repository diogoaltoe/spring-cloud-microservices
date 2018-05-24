package com.diogoaltoe.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diogoaltoe.microservices.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, String>{
	
	Authority findByName(String name);
	
}