package pk.GradeBook.service;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pk.GradeBook.model.Attendance;
import pk.GradeBook.util.Factory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AttendanceServiceTest {

    @Autowired
    private AttendanceServiceImpl attendanceService;

    @Autowired
    Factory factory;


    private static final Logger log = LoggerFactory.getLogger(AttendanceServiceTest.class);

    @Test
    void fetchSubjectAttendances() throws Exception{
        Attendance attendance1 = factory.newAttendance();
        Attendance attendance2 = factory.newAttendance();
        attendance1.setSubjectId(1L);
        attendance2.setSubjectId(2L);
        List<Attendance> response = new ArrayList<>();
        response.add(attendance1);
        response.add(attendance2);
        response = attendanceService.fetchSubjectAttendances(response, 1L);
        assertEquals(response.size(), 1);
    }

}