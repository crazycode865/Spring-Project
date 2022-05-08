package com.furnapp.service;

import com.furnapp.exception.FurnitureNotFoundException;
import com.furnapp.model.Category;
import com.furnapp.model.Furniture;
import com.furnapp.model.Material;
import com.furnapp.model.RoomType;

import java.util.List;

public interface IFurnitureService {
    public void addFurniture(Furniture furniture);
    public void deleteFurniture(int furnitureId);
    public void updateFurniture(int furnitureId,double price);

    Furniture getById(int furnitureId) throws FurnitureNotFoundException;
    List<Furniture> getByName(String name) throws  FurnitureNotFoundException;
    List<Furniture> getByMaterial(String material)throws  FurnitureNotFoundException;
    List<Furniture> getByStyle(String style)throws  FurnitureNotFoundException;
    List<Furniture> getByBrand(String brand)throws  FurnitureNotFoundException;
    List<Furniture> getByPriceRange(int minPrice,int maxPrice)throws  FurnitureNotFoundException;
    List<Furniture> getByRoomType(String roomType)throws FurnitureNotFoundException;
    List<Furniture> isStorageAvailable(Boolean flag);

}
