package com.productapp.service;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;

import java.time.LocalDate;
import java.util.List;

public interface IProductService {
    void addProduct(Product product);
    void updateProduct(int productId,double price);
    void deleteProduct(int productId);
    List<Product> getAll();
    List<Product> getByBrand(String brand)throws ProductNotFoundException;
    List<Product> getByCategory(String category) throws ProductNotFoundException;
    List<Product> getByLesserPrice(double price)throws  ProductNotFoundException;
    List<Product> getByBrandStarting(String brand)throws  ProductNotFoundException;
    Product getById(int productId)throws  ProductNotFoundException;
    List<Product> getByExpiryDate(LocalDate expiryDate);

}
