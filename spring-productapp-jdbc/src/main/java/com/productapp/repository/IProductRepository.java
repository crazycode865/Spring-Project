package com.productapp.repository;

import com.productapp.model.Product;

import java.time.LocalDate;
import java.util.List;

public interface IProductRepository {
    void addProduct(Product product);
    void updateProduct(int productId,double price);

    void deleteProduct(int productId);
    List<Product> findAll();
    List<Product> findByBrand(String brand);
    List<Product> findByCategory(String category);
    List<Product> findByLesserPrice(double price);
    List<Product> findByBrandStarting(String brand);
    Product findById(int productId);
    List<Product> findByExpiryDate(LocalDate expiryDate);
}
