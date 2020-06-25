package pk.GradeBook.service;

import pk.GradeBook.model.Subject;
import pk.GradeBook.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    void save(User user);

    User findById(long id);

    void deleteById(Long id);

    List<User> fetchStudentUsers(List<User> users);

    void addSubject(User user, Subject subject);

    void deleteSubject(User user, Subject subject);

    int maxAttendancesOfUsers(List<User> users);
  
    int getMarksLenBySubjectId(List<Subject> subjects, User user);

    int getAttendanceLenBySubjectId(List<Subject> subjects, User user);
}
