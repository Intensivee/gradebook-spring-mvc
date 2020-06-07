package pk.GradeBook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.GradeBook.model.Attendance;
import pk.GradeBook.repository.AttendanceRepository;

import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService{

    @Autowired
    AttendanceRepository repo;

    @Override
    public void save(Attendance attendance) {
        repo.save(attendance);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Attendance findById(Long id) {
        if (repo.findById(id).isPresent()) {
            return repo.findById(id).get();
        }
        else{
            return new Attendance();
        }
    }

    @Override
    public List<Attendance> findAll() {
        return repo.findAll();
    }

}
