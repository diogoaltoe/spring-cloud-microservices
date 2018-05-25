package com.diogoaltoe.microservices.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.diogoaltoe.microservices.model.Customer;

@RepositoryRestResource(collectionResourceRel = "customer", path = "customer")
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {
	
	@Query("SELECT c FROM Customer AS c WHERE LOWER(c.first_name) = LOWER(:firstName)")
    Customer findByFirstNameCaseInsensitive(@Param("firstName") String firstName);
	
}
