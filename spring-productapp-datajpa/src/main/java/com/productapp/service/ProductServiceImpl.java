package com.productapp.service;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Category;
import com.productapp.model.Product;
import com.productapp.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Component
public class ProductServiceImpl implements IProductService {
    @Autowired
    IProductRepository iProductRepository;

    @Override
    public void addProduct(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void deleteProduct(int productId) {
        iProductRepository.deleteById(productId);

    }

    @Override
    public List<Product> getAll() {
        return iProductRepository.findAll();
    }

    @Override
    public List<Product> getByBrand(String brand) throws ProductNotFoundException {
        return iProductRepository.findByBrand(brand);
    }

    @Override
    public List<Product> getByCategory(Category category) throws ProductNotFoundException {
        return iProductRepository.findByCategory(category);
    }

    @Override
    public List<Product> getByLesserPrice(double price) throws ProductNotFoundException {
        return iProductRepository.readByPriceLessThan(price);
    }

    @Override
    public List<Product> getByBrandStartingWith(String brand) throws ProductNotFoundException {
        return iProductRepository.findByBrandStartingWith(brand);
    }

    @Override
    public Product getById(int productId) throws ProductNotFoundException {

        return iProductRepository.findById(productId).orElseThrow(()->new ProductNotFoundException("Invalid Id"));
    }

    @Override
    public List<Product> getByExpiryDateLessThan(LocalDate expiryDate) {
        return iProductRepository.findByExpiryDateLessThan(expiryDate);
    }

    @Override
    public List<Product> getBrandCost(String brand, double price) {
        return iProductRepository.getBrandCost(brand,price);
    }

    @Override
    public List<Product> getByNewBrands(String brand) {
        return iProductRepository.getByNewBrands(brand);
    }

    @Override
    public List<Product> getByBrandExpiry(String brand, LocalDate expiryDate) {
        return iProductRepository.findByBrandExpiry(brand,expiryDate);
    }

    @Override
    public List<Product> getByBrandName(String brand, String name) {
        return iProductRepository.findByBrandName(brand,name);
    }

    @Override
    public List<Product> getByCatBrand(Category category, String brand) {
        return iProductRepository.findByCatBrand(category,brand);
    }

    @Override
    @Transactional
    public void updateProductCost(double cost, int productId) {
        iProductRepository.updateProductCost(cost,productId);
    }

    @Override
    public List<Product> getByBetweenPrice(double minPrice, double maxPrice) {
        return iProductRepository.getByBetweenPrice(minPrice,maxPrice);
    }
}
