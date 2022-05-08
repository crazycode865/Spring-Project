package com.productapp.repository;

import com.productapp.model.Product;
import com.productapp.util.Queries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
@Component
public class ProductRepositoryImpl implements IProductRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void addProduct(Product product) {
        Date expiryDate = Date.valueOf(product.getExpiryDate());
        Object[] productArray={product.getName(),product.getBrand(),product.getCategory(),product.getPrice(),expiryDate};
        jdbcTemplate.update(Queries.INSERTQUERY,productArray);

    }

    @Override
    public void updateProduct(int productId,double price){

        jdbcTemplate.update(Queries.UPDATEQUERY,price,productId);

    }

    @Override
    public void deleteProduct(int productId) {
        jdbcTemplate.update(Queries.DELETEQUERY,productId);

    }

    @Override
    public List<Product> findAll() {
        RowMapper<Product> productMapper = new ProductMapper();
        List<Product> products  = jdbcTemplate.query(Queries.SELECTQUERY,productMapper);
        return products;
    }

    @Override
    public List<Product> findByBrand(String brand) {

        return jdbcTemplate.query(Queries.BRANDQUERY,(rs, rowNum) -> {
            Product product = new Product();
            product.setProductId(rs.getInt("productId"));
            product.setCategory(rs.getString("category"));
            product.setPrice(rs.getFloat("price"));
            product.setBrand(rs.getString("brand"));
            Date date = rs.getDate("expiryDate");
            LocalDate expiryDate = date.toLocalDate();
            product.setExpiryDate(expiryDate);
            product.setName(rs.getString("name"));
            return product;
        },brand);
    }

    @Override
    public List<Product> findByCategory(String category) {
       RowMapper<Product> productMapper = new RowMapper<Product>() {
           @Override
           public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
               Product product = new Product();
               product.setProductId(rs.getInt("productId"));
               product.setCategory(rs.getString("category"));
               product.setPrice(rs.getFloat("price"));
               product.setBrand(rs.getString("brand"));
               Date date = rs.getDate("expiryDate");
               LocalDate expiryDate = date.toLocalDate();
               product.setExpiryDate(expiryDate);
               product.setName(rs.getString("name"));
               return product;
           }
       };
        return jdbcTemplate.query(Queries.CATEGORYQUERY,productMapper,category);
    }

    @Override
    public List<Product> findByLesserPrice(double price) {
       return jdbcTemplate.query(Queries.PRICEQUERY,(rs,row) -> {
            Product product = new Product();
            product.setProductId(rs.getInt("productId"));
            product.setCategory(rs.getString("category"));
            product.setPrice(rs.getFloat("price"));
            product.setBrand(rs.getString("brand"));
            Date date = rs.getDate("expiryDate");
            LocalDate expiryDate = date.toLocalDate();
            product.setExpiryDate(expiryDate);
            product.setName(rs.getString("name"));
            return product;
        },price);
       // return null;
    }

    @Override
    public List<Product> findByBrandStarting(String brand) {
        return jdbcTemplate.query(Queries.BRANDSTARTINGQUERY,(rs, rowNum) -> {
            Product product = new Product();
            product.setProductId(rs.getInt("productId"));
            product.setCategory(rs.getString("category"));
            product.setPrice(rs.getFloat("price"));
            product.setBrand(rs.getString("brand"));
            Date date = rs.getDate("expiryDate");
            LocalDate expiryDate = date.toLocalDate();
            product.setExpiryDate(expiryDate);
            product.setName(rs.getString("name"));
            return product;
        },brand+"%");
    }

    @Override
    public Product findById(int productId) {
       return jdbcTemplate.queryForObject(Queries.IDQUERY,(rs, rowNum) -> {
           Product product = new Product();
           product.setProductId(rs.getInt("productId"));
           product.setCategory(rs.getString("category"));
           product.setPrice(rs.getFloat("price"));
           product.setBrand(rs.getString("brand"));
           Date date = rs.getDate("expiryDate");
           LocalDate expiryDate = date.toLocalDate();
           product.setExpiryDate(expiryDate);
           product.setName(rs.getString("name"));
           return product;
       },productId);
    }



    @Override
    public List<Product> findByExpiryDate(LocalDate expiryDate){
        return jdbcTemplate.query(Queries.DATEQUERY,(rs, rowNum) -> {
            Product product = new Product();
            product.setProductId(rs.getInt("productId"));
            product.setCategory(rs.getString("category"));
            product.setPrice(rs.getFloat("price"));
            product.setBrand(rs.getString("brand"));
            Date date = rs.getDate("expiryDate");
            LocalDate date1 = date.toLocalDate();
            product.setExpiryDate(date1);
            product.setName(rs.getString("name"));
            return product;
        },expiryDate);
    }
}
