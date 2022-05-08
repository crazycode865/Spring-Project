package com.productapp.repository;

import com.productapp.model.Category;
import com.productapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface IProductRepository extends JpaRepository<Product,Integer> {
    //Derived Queries

    List<Product> findByCategory(Category category);
    List<Product> findByBrand(String brand);
    List<Product> readByPriceLessThan(double price);
    List<Product> findByExpiryDateLessThan(LocalDate localDate);
    List<Product> findByBrandStartingWith(String brand);

    //custom query JPQL - in terms of Java
    @Query("from Product p where p.brand=?1")
    List<Product> getByNewBrands(String brand);
    @Query("from Product p where p.brand=?1 and p.price<?2")
    List<Product> getBrandCost(String brand,double price);
    @Query(name="findByBrandExpiry")
    List<Product>findByBrandExpiry(String brand,LocalDate expiryDate);
    @Query(name="findByBrandName")
    List<Product> findByBrandName(String brand,String name);
    @Query(name="findByCatBrand")
    List<Product> findByCatBrand(Category category,String brand);

    //Native query is faster than other query
    @Modifying
    @Query(value="update newproduct set cost=?1 where product_id=?2",nativeQuery = true)
    void updateProductCost(double cost,int productId);

    @Query(value="select * from newproduct where cost between ?1 and ?2",nativeQuery = true)
    List<Product> getByBetweenPrice(double minPrice,double maxPrice);




}
