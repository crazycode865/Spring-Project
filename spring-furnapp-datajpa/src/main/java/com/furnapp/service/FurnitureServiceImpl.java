package com.furnapp.service;

import com.furnapp.exception.FurnitureNotFoundException;
import com.furnapp.model.Category;
import com.furnapp.model.Furniture;
import com.furnapp.model.Style;
import com.furnapp.repository.IFurnitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FurnitureServiceImpl implements IFurnitureService {
    @Autowired
    IFurnitureRepository iFurnitureRepository;

    @Override
    public void addFurniture(Furniture furniture) {
        iFurnitureRepository.save(furniture);
    }

    @Override
    public void deleteFurniture(int furnitureId) {
iFurnitureRepository.deleteById(furnitureId);
    }

    @Override
    public void updateFurniture(Furniture furniture) {
        iFurnitureRepository.save(furniture);

    }

    @Override
    public Furniture getById(int furnitureId) throws FurnitureNotFoundException {
      // return null;
         return iFurnitureRepository.findById(furnitureId).get();
    }

    @Override
    public List<Furniture> getAll() {
        return iFurnitureRepository.findAll();
    }

    @Override
    public List<Furniture> getByCategory(Category category) {
        return iFurnitureRepository.findByCategory(category);
    }

    @Override
    public List<Furniture> getByMaterial(String material) {
        return iFurnitureRepository.findByMaterial(material);
    }

    @Override
    public List<Furniture> getByStyle(Style style) {
        return iFurnitureRepository.findByStyle(style);
    }

    @Override
    public List<Furniture> getByBrand(String brand) {
        return iFurnitureRepository.findByBrand(brand);
    }

    @Override
    public List<Furniture> getByRoomType(String roomType) {
        return iFurnitureRepository.findByRoomType(roomType);
    }

    @Override
    public List<Furniture> getByStorageAvailable(boolean storage) {
        return iFurnitureRepository.findByStorageAvailable(storage);
    }

    @Override
    public List<Furniture> getByPriceRange(int minPrice, double maxPrice) {
        return iFurnitureRepository.findByPriceRange(minPrice,maxPrice);
    }

    @Override
    public List<Furniture> getByMatAndBrand(String material, String brand) {
        return iFurnitureRepository.findByMatAndBrand(material,brand);
    }

    @Override
    public List<Furniture> getByRoomAndCategory(String roomType, Category category) {
        return iFurnitureRepository.findByRoomAndCategory(roomType,category);
    }

    @Override
    public Integer getTotal() {
        return iFurnitureRepository.findTotal();
    }

    @Override
    public Integer getCategoryCost(Category category) {
        return iFurnitureRepository.findCategoryCost(category);
    }
}
