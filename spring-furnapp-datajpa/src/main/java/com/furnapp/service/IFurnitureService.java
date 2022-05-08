package com.furnapp.service;

import com.furnapp.exception.FurnitureNotFoundException;
import com.furnapp.model.Category;
import com.furnapp.model.Furniture;
import com.furnapp.model.Style;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IFurnitureService {
    public void addFurniture(Furniture furniture);
    public void deleteFurniture(int furnitureId);
    public void updateFurniture(Furniture furniture);

    Furniture getById(int furnitureId) throws FurnitureNotFoundException;
    List<Furniture>getAll();
    List<Furniture> getByCategory(Category category);
    List<Furniture> getByMaterial(String material);
    List<Furniture> getByStyle(Style style);
    List<Furniture> getByBrand(String brand);
    List<Furniture> getByRoomType(String roomType);
    List<Furniture> getByStorageAvailable(boolean storage);


    //Custom Query
    List<Furniture> getByPriceRange(int minPrice,double maxPrice);
    List<Furniture> getByMatAndBrand(String material,String brand);
    List<Furniture> getByRoomAndCategory(String roomType, Category category);
    Integer getTotal();
    Integer getCategoryCost(Category category);
}
