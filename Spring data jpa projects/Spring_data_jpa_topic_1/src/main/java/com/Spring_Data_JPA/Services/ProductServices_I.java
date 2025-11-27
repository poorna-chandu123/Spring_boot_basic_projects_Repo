package com.Spring_Data_JPA.Services;

import com.Spring_Data_JPA.Entity.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductServices_I {
    Product findByName(String name);
    Optional<Product> findById(Long id);
    List<Product> findByNameOrDescription(String name, String description);
    List<Product> findByNameAndDescription(String name, String description);
    Product findDistinctByName(String name);
    List<Product> findByPriceGreaterThan(BigDecimal price);

    List<Product> findByPriceLessThan(BigDecimal price);
    List<Product> findByNameContaining(String name);
    List<Product> findByNameLike(String name);
    List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);
    List<Product> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);
    List<Product> findByNameIn(List<String> names);
    List<Product> findFirst2ByOrderByNameAsc();
    List<Product> findTop2ByOrderByPriceDesc();
    Product findByNameOrDescriptionJPQLIndexParam(String name, String description);
    Product findByNameOrDescriptionJPQLNamedParam(String name, String description);
    Product findByNameOrDescriptionSQLIndexParam(String name, String description);
    Product findByNameOrDescriptionSQLNamedParam(String name, String description);
    Product findByPrice(BigDecimal price);
    List<Product> findAllByOrderByNameDesc();
    Product findByDescription(String description);
    List<Product> findAllByOrderByNameAsc();
}
