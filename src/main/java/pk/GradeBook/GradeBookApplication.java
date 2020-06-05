package pk.GradeBook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pk.GradeBook.repository.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class GradeBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(GradeBookApplication.class, args);
	}

}
