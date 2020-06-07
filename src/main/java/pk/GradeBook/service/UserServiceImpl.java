package pk.GradeBook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
}
