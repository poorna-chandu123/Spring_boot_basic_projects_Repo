package com.complete_demo_junit.Services;


import com.complete_demo_junit.Entity.Product;
import com.complete_demo_junit.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductServices_I{


    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findByNameOrDescription(String name, String description) {
        return productRepository.findByNameOrDescription(name, description);
    }

    @Override
    public List<Product> findByNameAndDescription(String name, String description) {
        return productRepository.findByNameAndDescription(name, description);
    }

    @Override
    public Product findDistinctByName(String name) {
        return productRepository.findDistinctByName(name);
    }

    @Override
    public List<Product> findByPriceGreaterThan(BigDecimal price) {
        return productRepository.findByPriceGreaterThan(price);
    }

    @Override
    public List<Product> findByPriceLessThan(BigDecimal price) {
        return productRepository.findByPriceLessThan(price);
    }

    @Override
    public List<Product> findByNameContaining(String name) {
        return productRepository.findByNameContaining(name);
    }

    @Override
    public List<Product> findByNameLike(String name) {
        return productRepository.findByNameLike(name);
    }

    @Override
    public List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice) {
        return productRepository.findByPriceBetween(startPrice, endPrice);
    }

    @Override
    public List<Product> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return productRepository.findByDateCreatedBetween(startDate, endDate);
    }

    @Override
    public List<Product> findByNameIn(List<String> names) {
        return productRepository.findByNameIn(names);
    }

    @Override
    public List<Product> findFirst2ByOrderByNameAsc() {
        return productRepository.findFirst2ByOrderByNameAsc();
    }

    @Override
    public List<Product> findTop2ByOrderByPriceDesc() {
        return productRepository.findTop2ByOrderByPriceDesc();
    }

    @Override
    public Product findByNameOrDescriptionJPQLIndexParam(String name, String description) {
        return productRepository.findByNameOrDescriptionJPQLIndexParam(name, description);
    }

    @Override
    public Product findByNameOrDescriptionJPQLNamedParam(String name, String description) {
        return productRepository.findByNameOrDescriptionJPQLNamedParam(name, description);
    }

    @Override
    public Product findByNameOrDescriptionSQLIndexParam(String name, String description) {
        return productRepository.findByNameOrDescriptionSQLIndexParam(name, description);
    }

    @Override
    public Product findByNameOrDescriptionSQLNamedParam(String name, String description) {
        return productRepository.findByNameOrDescriptionSQLNamedParam(name, description);
    }

    @Override
    public Product findByPrice(BigDecimal price) {
        return productRepository.findByPrice(price);
    }

    @Override
    public List<Product> findAllByOrderByNameDesc() {
        return productRepository.findAllByOrderByNameDesc();
    }

    @Override
    public Product findByDescription(String description) {
        return productRepository.findByDescription(description);
    }

    @Override
    public List<Product> findAllByOrderByNameAsc() {
        return productRepository.findAllByOrderByNameAsc();
    }
}

