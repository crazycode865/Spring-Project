package com.productapp;

import com.productapp.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class SpringProductappDatajpaApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(SpringProductappDatajpaApplication.class, args);
	}
    @Autowired
	IProductService iProductService;
	@Override
	public void run(String... args) throws Exception {
		LocalDate localDate = LocalDate.of(2019,5,13);
		//Product product = new Product("Specs", Category.TOYS,"Lenskart",4568,localDate);
		//iProductService.addProduct(product);
		//iProductService.getAll().forEach(System.out::println);
		//System.out.println(iProductService.getById(103));
		//iProductService.getByExpiryDate(localDate).forEach(System.out::println);
		//Product nproduct = iProductService.getById(101);
		//nproduct.setBrand("John Jacob");
		//nproduct.setPrice(9876);
		//iProductService.updateProduct(nproduct);
		iProductService.getByBrand("Lenskart").forEach(System.out::println);
		//iProductService.getByExpiryDateLessThan(localDate).forEach(System.out::println);
		//iProductService.getByCategory(Category.ELECTRONICS).forEach(System.out::println);
		//iProductService.getByLesserPrice(3458).forEach(System.out::println);
		//iProductService.getByBrandStartingWith("L").forEach(System.out::println);
		//iProductService.getBrandCost("Lenskart",3000).forEach(System.out::println);
		//iProductService.getByNewBrands("John Jacob").forEach(System.out::println);
	//	iProductService.getByBrandExpiry("Lenskart",localDate).forEach(System.out::println);
		//iProductService.getByBrandName("Lenskart","Specs").forEach(System.out::println);
		//iProductService.getByCatBrand(Category.ELECTRONICS, "Iphone").forEach(System.out::println);
		//iProductService.updateProductCost(2345,101);
		iProductService.getByBetweenPrice(2344,9876).forEach(System.out::println);


	}
}
