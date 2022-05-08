package com.productapp.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
//Named Query called by their name
@NamedQuery(name="findByBrandExpiry",
        query="from Product p where p.brand=?1 and p.expiryDate=?2")
@NamedQueries(value = {
        @NamedQuery(name="findByCatBrand",query="from Product p where p.category =?1 and p.brand=?2"),
        @NamedQuery(name="findByBrandName",query="from Product p where p.brand=?1 and p.name=?2")
})

@Table(name="newproduct")
public class Product {
    @Id
    @GeneratedValue(generator = "product_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "product_gen",sequenceName = "product_sequence",initialValue = 100,allocationSize = 1)
    private Integer productId;
    @Column(length = 20)
    private  String name;
    @Enumerated(EnumType.STRING)
    private  Category category;
    @Column(length = 20)
    private String brand;
    @Column(name="cost")
    private  double price;

    LocalDate expiryDate;

    public Product(String name, Category category, String brand, double price, LocalDate expiryDate) {
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.expiryDate = expiryDate;
    }
}
