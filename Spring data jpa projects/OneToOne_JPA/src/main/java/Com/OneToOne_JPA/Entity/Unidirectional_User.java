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
        name = "User_OneToOne",
        schema = "spring_data_jpa"

)

//Parent  table
public class Unidirectional_User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "Addid") // address_id (FK) foreign key child lo create avuthundi
    private Unidirectional_Address address;
}
