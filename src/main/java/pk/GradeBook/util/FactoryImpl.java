package pk.GradeBook.util;

import org.springframework.stereotype.Component;
import pk.GradeBook.model.*;

@Component
public class FactoryImpl implements Factory{
    @Override
    public Mark newMark() {
        return new Mark();
    }

    @Override
    public Event newEvent() {
        return new Event();
    }

    @Override
    public Attendance newAttendance() {
        return new Attendance();
    }

    @Override
    public User newUser() {
        return new User();
    }

    @Override
    public Subject newSubject() {
        return new Subject();
    }
}
