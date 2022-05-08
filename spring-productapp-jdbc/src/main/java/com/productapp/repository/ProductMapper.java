package com.productapp.repository;


import com.productapp.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;


public class ProductMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product  = new Product();
        product.setName(rs.getString("name"));
        product.setProductId(rs.getInt("productId"));
        product.setCategory(rs.getString("category"));
        product.setBrand(rs.getString("brand"));
        product.setPrice(rs.getFloat("price"));
        Date date =rs.getDate("expirydate");
        LocalDate expiryDate =   ((java.sql.Date) date).toLocalDate();
        product.setExpiryDate(expiryDate);
        return product;
    }
}
