package Com.ManyToMany.Entity;

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
        name = "ManyToMany_Bidirectional_Student",
        schema = "spring_data_jpa"

)
public class Bidirectional_Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "Bidirectional_student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    @JsonIgnore
    private List<Bidirectional_Course> courses = new ArrayList<>();

    // Getters and Setters
}
