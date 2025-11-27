package com.complete_demo_junit.Repository;

import com.complete_demo_junit.Entity.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//@DataJpaTest

@SpringBootTest
@TestPropertySource(locations = "classpath:application-h2.properties")
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    private Product product; // Define at class level

    @BeforeEach
    public void setUp() {
        // Initialize class-level product
        product = new Product();
        product.setName("product 1");
        product.setDescription("product 1 description");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product1.png");

        // Save product and assign returned entity (to capture ID)
        product = productRepository.save(product);
        productRepository.flush();
    }

   /* @AfterEach
    public void tearDown() {
        productRepository.deleteAll(); // Clear DB
    }
*/
/*    @Test
    void saveMethod() {
        // Create a new product
        Product newProduct = new Product();
        newProduct.setName("product 2");
        newProduct.setDescription("product 2 description");
        newProduct.setSku("200XYZ");
        newProduct.setPrice(new BigDecimal(200));
        newProduct.setActive(true);
        newProduct.setImageUrl("product2.png");

        // Save product
        Product savedObject = productRepository.save(newProduct);

        // Verify product was saved
        assertNotNull(savedObject.getId());
        assertEquals("product 2", savedObject.getName());
        System.out.println("Saved Product ID: " + savedObject.getId());
    }*/

    @Test
    public void findByNameOrDescription() {
        // Fetch product by name or description
        List<Product> productList = productRepository.findByNameOrDescription("product 1", "product 1 description");

        // Assertions
        assertNotNull(productList);
        assertFalse(productList.isEmpty());
        assertEquals("product 1", productList.get(0).getName());
        assertThat(productList.get(0).getImageUrl()).isEqualTo(product.getImageUrl());
        assertNotEquals("343223", productList.get(0).getSku());

        System.out.println("Test Passed: findByNameOrDescription");
    }
}

