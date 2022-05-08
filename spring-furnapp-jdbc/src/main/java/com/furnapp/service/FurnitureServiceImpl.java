package com.furnapp.service;
import com.furnapp.exception.FurnitureNotFoundException;
import com.furnapp.model.Furniture;
import com.furnapp.model.RoomType;
import com.furnapp.repository.IFurnitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class FurnitureServiceImpl implements  IFurnitureService{
    @Autowired
    IFurnitureRepository iFurnitureRepository;
    @Override
    public void addFurniture(Furniture furniture) {
      iFurnitureRepository.addFurniture(furniture);
    }

    @Override
    public void deleteFurniture(int furnitureId) {
        iFurnitureRepository.deleteFurniture(furnitureId);

    }

    @Override
    public void updateFurniture(int furnitureId, double price) {
        iFurnitureRepository.updateFurniture(furnitureId,price);

    }

    @Override
    public Furniture getById(int furnitureId) throws FurnitureNotFoundException {
        return iFurnitureRepository.findById(furnitureId);
    }

    @Override
    public List<Furniture> getByName(String name) throws FurnitureNotFoundException {
        return iFurnitureRepository.findByName(name);
    }

    @Override
    public List<Furniture> getByMaterial(String material) throws FurnitureNotFoundException {
        return iFurnitureRepository.findByMaterial(material);
    }

    @Override
    public List<Furniture> getByStyle(String style) throws FurnitureNotFoundException {
        return iFurnitureRepository.findByStyle(style);
    }

    @Override
    public List<Furniture> getByBrand(String brand) throws FurnitureNotFoundException {
        return iFurnitureRepository.findByBrand(brand);
    }

    @Override
    public List<Furniture> getByPriceRange(int minPrice, int maxPrice) throws FurnitureNotFoundException {
        return iFurnitureRepository.findByPriceRange(minPrice,maxPrice);
    }

    @Override
    public List<Furniture> getByRoomType(String roomType) throws FurnitureNotFoundException {
        return iFurnitureRepository.findByRoomType(roomType);
    }

    @Override
    public List<Furniture> isStorageAvailable(Boolean flag) {
        return iFurnitureRepository.isStorageAvailable(flag);
    }
}
