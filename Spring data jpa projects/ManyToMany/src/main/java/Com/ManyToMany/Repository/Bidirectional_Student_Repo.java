package Com.ManyToMany.Repository;

import Com.ManyToMany.Entity.Bidirectional_Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Bidirectional_Student_Repo extends JpaRepository<Bidirectional_Student, Long> {

}
