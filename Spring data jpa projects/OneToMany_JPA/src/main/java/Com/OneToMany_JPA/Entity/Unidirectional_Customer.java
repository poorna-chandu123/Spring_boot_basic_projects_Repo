package Com.OneToMany_JPA.Entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Table(
        name = "OneToMany_Unidirectional_Customer",
        schema = "spring_data_jpa"

)

public class Unidirectional_Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Customerid;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id") // customer_id (FK) foreign key child lo create avuthundi
    private List<Unidirectional_Orders> orders = new ArrayList<>();


}
