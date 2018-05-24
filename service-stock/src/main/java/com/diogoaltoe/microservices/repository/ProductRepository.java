package com.diogoaltoe.microservices.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.diogoaltoe.microservices.model.Product;

@RepositoryRestResource(collectionResourceRel = "product", path = "product")
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
	
	@Query("SELECT p FROM Product AS p WHERE LOWER(p.name) = LOWER(:name)")
    Product findByNameCaseInsensitive(@Param("name") String name);
	
}
