package Com.OneToMany_JPA.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
        name = "OneToMany_Bidirectional_Customer",
        schema = "spring_data_jpa"

)

public class Bidirectional_Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Bidirectional_Orders> orders = new ArrayList<>();

    //  Orders table ki refrences mapping ledu

}
