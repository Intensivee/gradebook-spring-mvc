package pk.GradeBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pk.GradeBook.model.UserSubject;

public interface UserSubjectRepository extends JpaRepository<UserSubject, Long> {
}
