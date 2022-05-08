package com.furnapp.repository;

import com.furnapp.model.Category;
import com.furnapp.model.Furniture;
import com.furnapp.model.Style;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FurnitureMapper implements RowMapper<Furniture> {

    @Override
    public Furniture mapRow(ResultSet rs, int rowNum) throws SQLException {
        Furniture furniture = new Furniture();
        furniture.setFurnitureId(rs.getInt("furniture_id"));
        furniture.setName(rs.getString("name"));
        furniture.setBrand(rs.getString("brand"));
        furniture.setCategory(Category.valueOf(rs.getString("category")));
        furniture.setStyle(Style.valueOf(rs.getString("style")));
        furniture.setMaterial(rs.getString("material"));
        furniture.setPrice(rs.getInt("price"));
        furniture.setRoomType(rs.getString("roomtype"));
        furniture.setStorageAvailable(rs.getBoolean("storageAvailable"));
        return furniture;
    }
}
