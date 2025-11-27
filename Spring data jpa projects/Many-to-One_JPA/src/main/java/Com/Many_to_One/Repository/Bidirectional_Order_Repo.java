package Com.Many_to_One.Repository;

import Com.Many_to_One.Entity.Bidirectional_Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Bidirectional_Order_Repo extends JpaRepository<Bidirectional_Order, Long> {
    List<Bidirectional_Order> findByCustomer_Id(Long customerId);

}
