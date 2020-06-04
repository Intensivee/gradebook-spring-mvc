package pk.GradeBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pk.GradeBook.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}
