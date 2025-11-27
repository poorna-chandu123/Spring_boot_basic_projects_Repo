package Com.OneToOne_JPA.Repository;

import Com.OneToOne_JPA.Entity.Unidirectional_User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface User_Repo extends JpaRepository<Unidirectional_User, Long> {


}
