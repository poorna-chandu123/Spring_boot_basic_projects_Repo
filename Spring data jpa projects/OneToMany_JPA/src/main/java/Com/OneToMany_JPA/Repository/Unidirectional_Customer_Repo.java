package Com.OneToMany_JPA.Repository;

import Com.OneToMany_JPA.Entity.Unidirectional_Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Unidirectional_Customer_Repo extends JpaRepository<Unidirectional_Customer, Long> {
   // Optional<Unidirectional_Customer> findById(Long customerId);

}
