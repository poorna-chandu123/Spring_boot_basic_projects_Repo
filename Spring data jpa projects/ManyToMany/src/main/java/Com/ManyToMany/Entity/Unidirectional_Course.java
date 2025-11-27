package Com.ManyToMany.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Table(
        name = "ManyToMany_Unidirectional_Course",
        schema = "spring_data_jpa"

)
public class Unidirectional_Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    // No @ManyToMany mapping here, because this is unidirectional

}
