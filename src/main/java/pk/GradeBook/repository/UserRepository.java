package pk.GradeBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pk.GradeBook.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
