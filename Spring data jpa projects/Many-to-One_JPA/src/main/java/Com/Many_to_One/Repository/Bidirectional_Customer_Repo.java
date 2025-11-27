package Com.Many_to_One.Repository;

import Com.Many_to_One.Entity.Bidirectional_Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Bidirectional_Customer_Repo extends JpaRepository<Bidirectional_Customer, Long> {

}
