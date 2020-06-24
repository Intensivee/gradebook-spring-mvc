package pk.GradeBook.util;

import pk.GradeBook.model.*;

public interface Factory {
    Mark newMark();
    Event newEvent();
    Attendance newAttendance();
    User newUser();
    Subject newSubject();
}
