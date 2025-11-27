package Com.OneToOne_JPA.Repository;

import Com.OneToOne_JPA.Entity.Unidirectional_Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Address_Repo extends JpaRepository<Unidirectional_Address, Long> {

}
