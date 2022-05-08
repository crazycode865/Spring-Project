package com.productapp.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product {
    private Integer productId;
    private String name;
    private  String category;
    private String brand;
    private  double price;
    LocalDate expiryDate;

    public Product(String name, String category, String brand, double price, LocalDate expiryDate) {
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.expiryDate = expiryDate;
    }
}
