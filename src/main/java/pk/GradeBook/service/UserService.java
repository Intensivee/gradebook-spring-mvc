package pk.GradeBook.service;

import pk.GradeBook.model.User;

import java.util.List;

public interface UserService {

    List<User> listAll();

    void save(User user);

    User get(long id);

    void delete(Long id);

}
