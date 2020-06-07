package pk.GradeBook.service;

import pk.GradeBook.model.Attendance;

import java.util.List;

public interface AttendanceService {

    void save(Attendance attendance);

    void deleteById(Long id);

    Attendance findById(Long id);

    List<Attendance> findAll();

}
