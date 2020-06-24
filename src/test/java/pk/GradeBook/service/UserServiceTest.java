package pk.GradeBook.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pk.GradeBook.model.User;
import pk.GradeBook.util.Factory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    Factory factory;

    @Test
    void fetchStudentUsers() {
        User user1 = factory.newUser();
        User user2 = factory.newUser();
        User user3 = factory.newUser();
        user1.setPerm(0);
        user2.setPerm(1);
        user3.setPerm(3);
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users = userService.fetchStudentUsers(users);
        assertEquals(users.size(), 1);
    }
}