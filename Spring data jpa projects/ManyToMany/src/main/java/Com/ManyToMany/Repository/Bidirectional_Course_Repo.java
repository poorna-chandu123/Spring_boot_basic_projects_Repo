package Com.ManyToMany.Repository;

import Com.ManyToMany.Entity.Bidirectional_Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Bidirectional_Course_Repo extends JpaRepository<Bidirectional_Course, Long> {

}
