package com.ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Product;

/**
 * @Project: hn-naitei19-02-ecommerce
 * @Author: sonle
 * @Date: 18/09/2023
 * @Time: 17:46
 */
@Repository
public interface ProductDAO extends DAO<Long, Product> {

    @Query("SELECT p FROM Product p WHERE p.name LIKE %?1% AND (p.price >= ?2 AND p.price <= ?3)")
    List<Product> findByConditions(String name, Integer minPrice, Integer maxPrice);
}
