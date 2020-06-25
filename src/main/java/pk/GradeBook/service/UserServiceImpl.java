package pk.GradeBook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.GradeBook.model.Attendance;
import pk.GradeBook.model.Mark;
import pk.GradeBook.model.Subject;
import pk.GradeBook.model.User;
import pk.GradeBook.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;


    @Override
    public List<User> findAll() {
        return repo.findAll();
    }


    @Override
    public void save(User user) {
        repo.save(user);
    }

    @Override
    public User findById(long id) {
        if (repo.findById(id).isPresent()) {
            return repo.findById(id).get();
        }
        else{
            return new User();
        }
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<User> fetchStudentUsers(List<User> users) {
        List<User> fetchedUsers = new ArrayList<User>();
        for (User user : users) {
            if (user.getPerm() == 0) {
                fetchedUsers.add(user);
            }
        }
        return fetchedUsers;
    }

    @Override
    public void addSubject(User user, Subject subject) {
        user.getSubjects().add(subject);
    }

    @Override
    public void deleteSubject(User user, Subject subject) {
        user.getSubjects().remove(subject);
    }

    @Override
    public int maxAttendancesOfUsers(List<User> users) {
        int maxAttendanceNumber = 0;
        for(User user : users){
            if(user.getAttendances().size() > maxAttendanceNumber){
                maxAttendanceNumber = user.getAttendances().size();
            }
        }
        return maxAttendanceNumber;
    }
  
    @Override
    public int getMarksLenBySubjectId(List<Subject> subjects, User user) {
        int max = 0;
        List<Mark> fetchedMarks = new ArrayList<>();
        for(Subject subject: subjects){
            for(Mark mark: user.getMarks()){
                if(mark.getSubjectId().equals(subject.getSubjectId())){
                    fetchedMarks.add(mark);
                }
            }
            if(max < fetchedMarks.size()){
                max = fetchedMarks.size();
            }
            fetchedMarks.clear();
        }
        return max;
    }

    @Override
    public int getAttendanceLenBySubjectId(List<Subject> subjects, User user) {
        int max = 0;
        List<Attendance> fetchedAttendances = new ArrayList<>();
        for(Subject subject: subjects){
            for(Attendance attendance: user.getAttendances()){
                if(attendance.getSubjectId().equals(subject.getSubjectId())){
                    fetchedAttendances.add(attendance);
                }
            }
            if(max < fetchedAttendances.size()){
                max = fetchedAttendances.size();
            }
            fetchedAttendances.clear();
        }
        return max;
    }
}
