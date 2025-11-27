package com.Spring_Data_JPA.Controller;

import com.Spring_Data_JPA.Entity.Product;
import com.Spring_Data_JPA.Services.ProductServices_I;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServices_I productService;

    @GetMapping("/name/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable String name) {
        return ResponseEntity.ok(productService.findByName(name));
    }

 /*   @GetMapping("/id/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }*/

    @GetMapping("/id/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/search")
    public ResponseEntity<List<Product>> getProductsByNameOrDescription(
            @RequestParam String name,
            @RequestParam String description) {
        return ResponseEntity.ok(productService.findByNameOrDescription(name, description));
    }

    @GetMapping("/price/greater/{price}")
    public ResponseEntity<List<Product>> getProductsByPriceGreaterThan(@PathVariable BigDecimal price) {
        return ResponseEntity.ok(productService.findByPriceGreaterThan(price));
    }

    @GetMapping("/price/less/{price}")
    public ResponseEntity<List<Product>> getProductsByPriceLessThan(@PathVariable BigDecimal price) {
        return ResponseEntity.ok(productService.findByPriceLessThan(price));
    }

    @GetMapping("/price/between")
    public ResponseEntity<List<Product>> getProductsByPriceBetween(
            @RequestParam BigDecimal startPrice,
            @RequestParam BigDecimal endPrice) {
        return ResponseEntity.ok(productService.findByPriceBetween(startPrice, endPrice));
    }

    @GetMapping("/date/between")
    public ResponseEntity<List<Product>> getProductsByDateBetween(
            @RequestParam LocalDateTime startDate,
            @RequestParam LocalDateTime endDate) {
        return ResponseEntity.ok(productService.findByDateCreatedBetween(startDate, endDate));
    }

    @GetMapping("/first2")
    public ResponseEntity<List<Product>> getFirst2ProductsByNameAsc() {
        return ResponseEntity.ok(productService.findFirst2ByOrderByNameAsc());
    }

    @GetMapping("/top2")
    public ResponseEntity<List<Product>> getTop2ProductsByPriceDesc() {
        return ResponseEntity.ok(productService.findTop2ByOrderByPriceDesc());
    }

    @GetMapping("/query/jpql")
    public ResponseEntity<Product> getProductByJPQL(
            @RequestParam String name,
            @RequestParam String description) {
        return ResponseEntity.ok(productService.findByNameOrDescriptionJPQLNamedParam(name, description));
    }

    @GetMapping("/query/sql")
    public ResponseEntity<Product> getProductBySQL(
            @RequestParam String name,
            @RequestParam String description) {
        return ResponseEntity.ok(productService.findByNameOrDescriptionSQLNamedParam(name, description));
    }

    @GetMapping("/all/desc")
    public ResponseEntity<List<Product>> getAllProductsOrderByNameDesc() {
        return ResponseEntity.ok(productService.findAllByOrderByNameDesc());
    }

    @GetMapping("/all/asc")
    public ResponseEntity<List<Product>> getAllProductsOrderByNameAsc() {
        return ResponseEntity.ok(productService.findAllByOrderByNameAsc());
    }
}
