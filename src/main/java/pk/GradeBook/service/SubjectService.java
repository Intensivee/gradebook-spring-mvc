package pk.GradeBook.service;

import pk.GradeBook.model.Subject;

import java.util.List;

public interface SubjectService {

    void save(Subject subject);

    void deleteById(Long id);

    Subject findById(Long id);

    List<Subject> findAll();

}
