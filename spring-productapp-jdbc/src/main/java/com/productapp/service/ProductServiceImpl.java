package com.productapp.service;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
@Component
public class ProductServiceImpl implements IProductService{
    @Autowired
    private IProductRepository iProductRepository;
    @Override
    public void addProduct(Product product) {
       iProductRepository.addProduct(product);
    }

    @Override
    public  void updateProduct(int productId,double price){
        iProductRepository.updateProduct(productId,price);

    }

    @Override
    public void deleteProduct(int productId) {
        iProductRepository.deleteProduct(productId);

    }

    @Override
    public List<Product> getAll() {

        return iProductRepository.findAll();
    }

    @Override
    public List<Product> getByBrand(String brand) {
        List<Product> products = iProductRepository.findByBrand(brand);
        if(products.isEmpty())
            throw new ProductNotFoundException("Brand not Found");
        return products;
    }

    @Override
    public List<Product> getByCategory(String category) {
        List<Product> products =iProductRepository.findByCategory(category);
        if(products.isEmpty())
            throw new ProductNotFoundException("Category not Found");
        return products;
    }

    @Override
    public List<Product> getByLesserPrice(double price) {
        List<Product> products = iProductRepository.findByLesserPrice(price);
        if(products.isEmpty())
            throw  new ProductNotFoundException("Product with lesser Price");
        return products;
    }

    @Override
    public List<Product> getByBrandStarting(String brand) {
        List<Product> products = iProductRepository.findByBrandStarting(brand);
        return products;
    }

    @Override
    public Product getById(int productId) {
        Product product = iProductRepository.findById(productId);
        if(product==null)
            throw new ProductNotFoundException("Id not Found");
        return product;
    }

    @Override
    public List<Product> getByExpiryDate(LocalDate expiryDate) {
        List<Product> products = iProductRepository.findByExpiryDate(expiryDate);
        if(products.isEmpty())
            throw new ProductNotFoundException("Expiry Date not Found");
        return products;
    }
}
