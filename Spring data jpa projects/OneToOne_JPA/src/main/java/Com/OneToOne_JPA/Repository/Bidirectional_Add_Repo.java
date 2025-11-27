package Com.OneToOne_JPA.Repository;

import Com.OneToOne_JPA.Entity.Bidirectional_Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Bidirectional_Add_Repo extends JpaRepository<Bidirectional_Address, Long> {
}
