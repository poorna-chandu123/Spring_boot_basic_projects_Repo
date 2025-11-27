package Com.Many_to_One.Repository;

import Com.Many_to_One.Entity.Unidirectional_Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Unidirectional_Order_Repo extends JpaRepository<Unidirectional_Order, Long> {

   // List<Unidirectional_Order> findByCustomer_Coustomerid(Long customerId);

}
