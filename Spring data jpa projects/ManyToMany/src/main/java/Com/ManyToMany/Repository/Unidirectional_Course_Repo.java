package Com.ManyToMany.Repository;

import Com.ManyToMany.Entity.Unidirectional_Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Unidirectional_Course_Repo extends JpaRepository<Unidirectional_Course, Long> {


}
