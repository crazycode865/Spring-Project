package com.productapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.productapp.model.Product;
@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
	   @Query("from Product p where p.category like ?1 or p.brand like ?1")
	   List<Product> getByChoice(String choice);
	   
	   List<Product> getByCategory(String category);
	   List<Product> findByNameStartingWith(String name);

	   List<Product> findByPriceLessThan(double price);
}
