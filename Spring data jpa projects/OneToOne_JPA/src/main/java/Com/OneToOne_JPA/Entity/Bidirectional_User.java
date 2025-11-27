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
        name = "Bidirectional_User_OneToOne",
        schema = "spring_data_jpa"

)
// Parent  table
public class Bidirectional_User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BIaddress_id", referencedColumnName = "Addid")
    //@JsonIgnore  // 👈 This will prevent infinite recursion
    private Bidirectional_Address address;
}
