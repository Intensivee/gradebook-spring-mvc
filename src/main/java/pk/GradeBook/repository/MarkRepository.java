package pk.GradeBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pk.GradeBook.model.Mark;

public interface MarkRepository extends JpaRepository<Mark, Long> {
}
