package com.furnapp;

import com.furnapp.model.*;
import com.furnapp.repository.IFurnitureRepository;
import com.furnapp.service.IFurnitureService;
//import com.productapp.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FurnappDatajpaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(FurnappDatajpaApplication.class, args);
    }

    @Autowired
    IFurnitureService iFurnitureService;

    @Override
    public void run(String... args) throws Exception {
        Furniture furniture = new Furniture("Table", Category.TABLE, RoomType.OFFICE.type,
                Material.WOOD.type, Style.MODERN, "Armani casa", 5670, false);
        iFurnitureService.addFurniture(furniture);
        iFurnitureService.deleteFurniture(103);
        iFurnitureService.getByStyle(Style.TRADITIONAL).forEach(System.out::println);
        iFurnitureService.getByRoomType(RoomType.GUEST.type).forEach(System.out::println);
        iFurnitureService.getByMaterial(Material.WOOD.type).forEach(System.out::println);
        System.out.println(iFurnitureService.getById(105));
        iFurnitureService.getByStyle(Style.MODERN).forEach(System.out::println);
        iFurnitureService.getAll().forEach(System.out::println);
        iFurnitureService.getByMatAndBrand(Material.PLASTIC.type, "Neelkamal").forEach(System.out::println);
        iFurnitureService.getByPriceRange(1234, 34567).forEach(System.out::println);
        iFurnitureService.getByRoomAndCategory(RoomType.LIVING.type, Category.BEDS).forEach(System.out::println);
        iFurnitureService.getByStorageAvailable(true).forEach(System.out::println);
        System.out.println(iFurnitureService.getCategoryCost(Category.BEDS));
        System.out.println(iFurnitureService.getTotal());


    }
}
