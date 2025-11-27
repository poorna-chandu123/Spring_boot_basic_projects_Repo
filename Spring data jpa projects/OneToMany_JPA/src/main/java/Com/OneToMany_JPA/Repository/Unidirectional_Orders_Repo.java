package Com.OneToMany_JPA.Repository;

import Com.OneToMany_JPA.Entity.Unidirectional_Customer;
import Com.OneToMany_JPA.Entity.Unidirectional_Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Unidirectional_Orders_Repo extends JpaRepository<Unidirectional_Orders, Long> {

}
