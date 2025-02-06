package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(String category);
    
    //example of custom hql query
    @Query("SELECT p FROM Product p WHERE p.category = :category AND p.price = :price")
    List<Product> findByCategoryAndPrice(@Param("category") String category, @Param("price") double price);
}

