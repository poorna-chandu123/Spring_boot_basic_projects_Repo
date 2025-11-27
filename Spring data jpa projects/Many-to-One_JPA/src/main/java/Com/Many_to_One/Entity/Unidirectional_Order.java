package Com.Many_to_One.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Table(
        name = "ManyToOne_Unidirectional_Order",
        schema = "spring_data_jpa"

)
public class Unidirectional_Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderid;

    private String product;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "customer_id") // Foreign key column in Order table
    private Unidirectional_Customer customer;

    // Getters and Setters
}
