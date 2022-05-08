package com.productapp.service;

import java.util.List;

import com.productapp.model.Product;

public interface IProductService {
	void addProduct(Product product);
	void deleteProduct(int product);
	void updateProduct(Product product);
	Product getById(int productId);
	List<Product> getAll();
	   List<Product> getByCategory(String category);
	   List<Product> getByPriceLessThan(double price);
	   List<Product> getByNameStartingWith(String name);
	   
	   List<Product> getByChoice(String choice);
}
