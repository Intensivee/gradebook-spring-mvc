package pk.GradeBook.service;

import pk.GradeBook.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    void save(User user);

    User findById(long id);

    void deleteById(Long id);

}
