package pk.GradeBook.service;

import pk.GradeBook.model.Mark;
import pk.GradeBook.model.Subject;

import java.util.List;

public interface MarkService {
    void save(Mark mark);

    void deleteById(Long id);

    Mark findById(Long id);

    List<Mark> findAll();

    List<Mark> fetchSubjectMarks(List<Mark> marks, Long subjectId);

    int maxMarksInSubjectStudents(Subject subject);
}
