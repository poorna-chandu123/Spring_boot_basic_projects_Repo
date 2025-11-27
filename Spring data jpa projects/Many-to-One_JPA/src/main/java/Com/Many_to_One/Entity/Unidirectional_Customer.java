package Com.Many_to_One.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Table(
        name = "ManyToOne_Unidirectional_Customer",
        schema = "spring_data_jpa"

)
public class Unidirectional_Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Coustomerid;

    private String name;

    // No reference to Order (Unidirectional)
}

