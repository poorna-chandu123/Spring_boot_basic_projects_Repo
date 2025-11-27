package Com.ManyToMany.Entity;

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
        name = "ManyToMany_Bidirectional_Course",
        schema = "spring_data_jpa"

)
public class Bidirectional_Course {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany(mappedBy = "courses")
    private List<Bidirectional_Student> students = new ArrayList<>();

    // Getters and Setters
}
