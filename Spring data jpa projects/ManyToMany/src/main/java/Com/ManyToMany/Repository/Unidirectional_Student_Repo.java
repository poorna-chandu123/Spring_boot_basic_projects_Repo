package Com.ManyToMany.Repository;

import Com.ManyToMany.Entity.Unidirectional_Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Unidirectional_Student_Repo extends JpaRepository<Unidirectional_Student, Long> {

}
