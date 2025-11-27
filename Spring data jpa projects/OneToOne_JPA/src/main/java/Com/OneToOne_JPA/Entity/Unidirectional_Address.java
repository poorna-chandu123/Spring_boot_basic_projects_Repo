package Com.OneToOne_JPA.Entity;

import jakarta.persistence.*;
import lombok.*;


@Entity

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Table(
        name = "Address_OneToOne",
        schema = "spring_data_jpa"

)
//Child table
public class Unidirectional_Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Addid;
    private String street;
    private String city;
}

