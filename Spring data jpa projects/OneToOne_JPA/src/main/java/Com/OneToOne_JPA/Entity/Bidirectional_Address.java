package Com.OneToOne_JPA.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Table(
        name = "Bidirectional_Add_OneToOne",
        schema = "spring_data_jpa"

)
// Child table
public class Bidirectional_Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Addid;
    private String street;
    private String city;

    @OneToOne(mappedBy = "address")  // Refers to the "address" field in User

    @JsonIgnore  // 👈 This will prevent infinite recursion
    private Bidirectional_User user;
}
