package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.model.Product;
import com.productapp.repository.IProductRepository;
@Service
public class ProductServiceImpl implements IProductService {
@Autowired
IProductRepository iProductRepository;
	@Override
	public void addProduct(Product product) {
		iProductRepository.save(product);
		
	}

	@Override
	public void deleteProduct(int product) {
		iProductRepository.deleteById(product);
		
	}

	@Override
	public void updateProduct(Product product) {
		iProductRepository.save(product);
		
	}

	@Override
	public List<Product> getAll() {
		return iProductRepository.findAll();
	}


	@Override
	public List<Product> getByCategory(String category) {
		return iProductRepository.getByCategory(category);
	}


	@Override
	public List<Product> getByNameStartingWith(String name) {
		return iProductRepository.findByNameStartingWith(name);
	}

	@Override
	public List<Product> getByChoice(String choice) {
		return iProductRepository.getByChoice("%"+choice+"%");
	}

	@Override
	public Product getById(int productId) {
		return iProductRepository.getById(productId);
	}

	@Override
	public List<Product> getByPriceLessThan(double price) {
		return iProductRepository.findByPriceLessThan(price);
	}
	

}
