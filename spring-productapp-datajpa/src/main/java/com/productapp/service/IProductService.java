package com.productapp.service;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Category;
import com.productapp.model.Product;

import java.time.LocalDate;
import java.util.List;

public interface IProductService {
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int productId);
    List<Product> getAll();
    List<Product> getByBrand(String brand)throws ProductNotFoundException;
    List<Product> getByCategory(Category category) throws ProductNotFoundException;
    List<Product> getByLesserPrice(double price)throws  ProductNotFoundException;
    List<Product> getByBrandStartingWith(String brand)throws  ProductNotFoundException;
    Product getById(int productId)throws  ProductNotFoundException;
    List<Product> getByExpiryDateLessThan(LocalDate expiryDate);
    List<Product> getBrandCost(String brand,double price);
    List<Product> getByNewBrands(String band);
    List<Product>getByBrandExpiry(String brand,LocalDate expiryDate);
    List<Product> getByBrandName(String brand,String name);
    List<Product> getByCatBrand(Category category,String brand);
    void updateProductCost(double cost,int productId);
    List<Product> getByBetweenPrice(double minPrice,double maxPrice);

}
