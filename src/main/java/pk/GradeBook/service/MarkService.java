package pk.GradeBook.service;

import pk.GradeBook.model.Mark;

import java.util.List;

public interface MarkService {
    void save(Mark mark);

    void deleteById(Long id);

    Mark findById(Long id);

    List<Mark> findAll();
}
