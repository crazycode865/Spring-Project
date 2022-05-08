package com.furnapp.repository;

import com.furnapp.model.Category;
import com.furnapp.model.Furniture;
import com.furnapp.model.RoomType;
import com.furnapp.model.Style;
import com.furnapp.util.Queries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class FurnitureRepositoryImpl implements IFurnitureRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public void addFurniture(Furniture furniture) {
        Object[] furnitureArray = {furniture.getName(),
                furniture.getCategory().name(),
                furniture.getRoomType(),
                furniture.getMaterial(),
                furniture.getStyle().name(),
                furniture.getBrand(),
                furniture.getPrice(),
                furniture.isStorageAvailable()};
        jdbcTemplate.update(Queries.INSERTQUERY,furnitureArray);

    }

    @Override
    public void deleteFurniture(int furnitureId) {
        jdbcTemplate.update(Queries.DELETEQUERY,furnitureId);

    }

    @Override
    public void updateFurniture(int furnitureId, double price) {
        jdbcTemplate.update(Queries.UPDATEQUERY,price,furnitureId);

    }

    @Override
    public Furniture findById(int furnitureId) {
        RowMapper<Furniture> rowMapper  = new FurnitureMapper();
        return jdbcTemplate.queryForObject(Queries.IDQUERY,rowMapper,furnitureId);
    }

    @Override
    public List<Furniture> findByName(String name) {
        RowMapper<Furniture> rowMapper  = new FurnitureMapper();
        return jdbcTemplate.query(Queries.BYNAMEQUERY,rowMapper,name);
    }

    @Override
    public List<Furniture> findByMaterial(String material) {
        RowMapper<Furniture> rowMapper  = new FurnitureMapper();
        return jdbcTemplate.query(Queries.MATERIALQUERY,rowMapper,material);
    }

    @Override
    public List<Furniture> findByStyle(String style) {
        RowMapper<Furniture> rowMapper  = new FurnitureMapper();
        return jdbcTemplate.query(Queries.STYLEQUERY,rowMapper,style);
    }

    @Override
    public List<Furniture> findByBrand(String brand) {
        RowMapper<Furniture> rowMapper  = new FurnitureMapper();
        return jdbcTemplate.query(Queries.BRANDQUERY,rowMapper,brand);
    }

    @Override
    public List<Furniture> findByPriceRange(int minPrice, int maxPrice) {
        RowMapper<Furniture> rowMapper  = new FurnitureMapper();
        return jdbcTemplate.query(Queries.PRICEQUERY,rowMapper,minPrice,maxPrice);
    }

    @Override
    public List<Furniture> findByRoomType(String roomType) {
        RowMapper<Furniture> rowMapper  = new FurnitureMapper();
        return jdbcTemplate.query(Queries.ROOMTYPEQUERY,rowMapper,roomType);
    }

    @Override
    public List<Furniture> isStorageAvailable(Boolean flag)
    {
        return jdbcTemplate.query(Queries.AVAILABILITYQUERY,new FurnitureMapper(),flag);
    }
}
