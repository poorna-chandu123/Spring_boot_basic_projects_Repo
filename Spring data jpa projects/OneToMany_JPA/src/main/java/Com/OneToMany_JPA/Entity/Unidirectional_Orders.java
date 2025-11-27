package Com.OneToMany_JPA.Entity;

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
        name = "OneToMany_Unidirectional_Orders",
        schema = "spring_data_jpa"

)

public class Unidirectional_Orders {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Orderid;

    private String product;
    private BigDecimal price;

    // No reference to Customer (Unidirectional)

    // Getters and Setters
}
