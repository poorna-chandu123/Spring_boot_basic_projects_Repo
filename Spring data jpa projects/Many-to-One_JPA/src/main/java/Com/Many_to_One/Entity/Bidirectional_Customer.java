package Com.Many_to_One.Entity;

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
        name = "ManyToOne_Bidirectional_Customer",
        schema = "spring_data_jpa"

)
public class Bidirectional_Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bidirectional_Order> orders = new ArrayList<>();

    // Getters and Setters
}
