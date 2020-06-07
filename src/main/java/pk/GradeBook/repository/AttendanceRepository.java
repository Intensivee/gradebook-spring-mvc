package pk.GradeBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pk.GradeBook.model.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}
