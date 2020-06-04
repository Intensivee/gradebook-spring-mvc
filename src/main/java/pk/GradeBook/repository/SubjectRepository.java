package pk.GradeBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pk.GradeBook.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
