package Com.OneToMany_JPA.Entity;


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
        name = "OneToMany_Bidirectional_Orders",
        schema = "spring_data_jpa"

)

public class Bidirectional_Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "customer_id") // Foreign key column in Order table
    @JsonIgnore  // 👈 Fixes infinite loop
    private Bidirectional_Customer customer;


}
