package Com.OneToMany_JPA.Repository;

import Com.OneToMany_JPA.Entity.Bidirectional_Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Bidirectional_Customer_Repo extends JpaRepository<Bidirectional_Customer, Long> {
}
