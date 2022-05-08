package com.productapp;

import com.productapp.model.Category;
import com.productapp.model.Product;
import com.productapp.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class SpringProductappJdbcApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringProductappJdbcApplication.class, args);
    }

    @Autowired
    IProductService iProductService;

    @Override
    public void run(String... args) throws Exception {
        LocalDate expiryDate = LocalDate.of(2022, 10, 02);
        String category = Category.ELECTRONICS.type;
        Product product = new Product("Mobile", category, "Samsung", 4567, expiryDate);
        //iProductService.addProduct(product);
       // Product product1 = new Product("Ball", Category.TOYS.type, "Adidas", 2345, LocalDate.of(2021, 04, 19));
       // iProductService.addProduct(product1);
        //Delete Product
       // iProductService.deleteProduct(2);
        //Update Product
       iProductService.updateProduct(1,8765);
//        System.out.println("Product By brand");
//        iProductService.getByBrand("Adidas").forEach(System.out::println);
//        System.out.println("product By category");
//        iProductService.getByCategory(category).forEach(System.out::println);
        System.out.println("Product by Id");
        System.out.println(iProductService.getById(1));
//        System.out.println("Product By Lesser price");
//        iProductService.getByLesserPrice(3000).forEach(System.out::println);
//        System.out.println("Product Starting By ");
//        iProductService.getByBrandStarting("A").forEach(System.out::println);
//        System.out.println("Product By Expiry Date");
//        LocalDate edate = LocalDate.parse("2021-04-19");
//        iProductService.getByExpiryDate(edate).forEach(System.out::println);


    }
}
