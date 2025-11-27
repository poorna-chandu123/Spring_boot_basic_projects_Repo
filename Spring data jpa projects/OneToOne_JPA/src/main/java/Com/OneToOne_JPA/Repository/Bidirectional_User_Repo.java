package Com.OneToOne_JPA.Repository;

import Com.OneToOne_JPA.Entity.Bidirectional_User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Bidirectional_User_Repo extends JpaRepository<Bidirectional_User, Long> {
}
