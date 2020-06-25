package pk.GradeBook.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pk.GradeBook.model.Mark;
import pk.GradeBook.model.Subject;
import pk.GradeBook.model.User;
import pk.GradeBook.util.Factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MarkServiceTest {

    @Autowired
    private MarkService markService;

    @Autowired
    private Factory factory;

    @Test
    void fetchSubjectMarks() {
        Mark mark1 = factory.newMark();
        Mark mark2 = factory.newMark();
        mark1.setSubjectId(1L);
        mark2.setSubjectId(2L);
        List<Mark> marks = new ArrayList<>();
        marks.add(mark1);
        marks.add(mark2);
        int response = markService.fetchSubjectMarks(marks, 1L).size();
        assertEquals(response,1);
    }

    @Test
    void maxMarksInSubjectStudents() {
        Mark mark1 = factory.newMark();
        Mark mark2 = factory.newMark();
        mark1.setSubjectId(1L);
        mark2.setSubjectId(2L);

        List<Mark> marks1 = new ArrayList<>();
        marks1.add(mark1);
        marks1.add(mark1);
        marks1.add(mark2);

        List<Mark> marks2 = new ArrayList<>();
        marks2.add(mark2);
        marks2.add(mark2);
        marks2.add(mark2);

        User user1 = factory.newUser();
        user1.setMarks(marks1);

        User user2 = factory.newUser();
        user2.setMarks(marks2);

        Subject subject = factory.newSubject();
        subject.setSubjectId(1L);
        subject.setUsers(Arrays.asList(user1, user2));

        int response = markService.maxMarksInSubjectStudents(subject);
        assertEquals(response, 2);


    }
}