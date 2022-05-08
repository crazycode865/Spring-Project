package com.furnapp.repository;

import com.furnapp.model.Furniture;
import com.furnapp.model.RoomType;

import java.util.List;

public interface IFurnitureRepository {
    public void addFurniture(Furniture furniture);
    public void deleteFurniture(int furnitureId);
    public void updateFurniture(int furnitureId,double price);

    Furniture findById(int furnitureId);
    List<Furniture> findByName(String name);
    List<Furniture> findByMaterial(String material);
    List<Furniture> findByStyle(String style);
    List<Furniture> findByBrand(String brand);
    List<Furniture> findByPriceRange(int minPrice,int maxPrice);
    List<Furniture> findByRoomType(String roomType);
    List<Furniture> isStorageAvailable(Boolean flag);
}
