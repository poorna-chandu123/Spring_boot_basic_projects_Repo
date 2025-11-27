package com.complete_demo_junit.Entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

/*@Table(
        name = "products",
        schema = "junit_test",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "sku_unique",
                        columnNames = "stock_keeping_unit"
                )
        }
)*/
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "stock_keeping_unit", nullable = false)
    private String sku;

    @Column(nullable = false)
    private String name;

    private String description;
    private BigDecimal price;
    private boolean active;
    private String imageUrl;

    @CreationTimestamp
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    private LocalDateTime lastUpdated;


}
