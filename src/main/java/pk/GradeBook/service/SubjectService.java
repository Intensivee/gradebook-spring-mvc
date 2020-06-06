package pk.GradeBook.service;

import pk.GradeBook.model.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectService {

    void save(Subject subject);

    void deleteById(Long id);

    List<Subject> findAll();

}
