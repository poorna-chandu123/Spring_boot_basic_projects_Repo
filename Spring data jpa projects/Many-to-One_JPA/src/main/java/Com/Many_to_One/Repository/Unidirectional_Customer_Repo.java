package Com.Many_to_One.Repository;

import Com.Many_to_One.Entity.Unidirectional_Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Unidirectional_Customer_Repo extends JpaRepository<Unidirectional_Customer, Long> {


}
