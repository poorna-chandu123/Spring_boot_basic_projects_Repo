package Com.Many_to_One.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
        name = "ManyToOne_Bidirectional_Order",
        schema = "spring_data_jpa"

)
public class Bidirectional_Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "customer_id")

    @JsonIgnore
    private Bidirectional_Customer customer;

    // Getters and Setters
}
