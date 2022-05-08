package com.furnapp;

import com.furnapp.model.*;
import com.furnapp.service.IFurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringFurnappJdbcApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(SpringFurnappJdbcApplication.class, args);
	}
	@Autowired
	IFurnitureService iFurnitureService;
	@Override
	public void run(String... args) throws Exception {
		Furniture furniture  = new Furniture("Bed", Category.BEDS, RoomType.DINING.type,
				Material.SWOOD.type, Style.TRADITIONAL, "Dews",3458,true);
		//iFurnitureService.addFurniture(furniture);
		//iFurnitureService.deleteFurniture(5);
		//iFurnitureService.updateFurniture(2,12346);
		iFurnitureService.isStorageAvailable(false).forEach(System.out::println);
		iFurnitureService.getByBrand("Maharaja").forEach(System.out::println);
		System.out.println(iFurnitureService.getById(2));
		iFurnitureService.getByMaterial("plastic").forEach(System.out::println);
		iFurnitureService.getByPriceRange(5000,10000).forEach(System.out::println);
		iFurnitureService.getByRoomType(RoomType.BED.type).forEach(System.out::println);
		iFurnitureService.getByStyle(Style.TRADITIONAL.name()).forEach(System.out::println);
	}
}
