package pk.GradeBook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.GradeBook.model.Subject;
import pk.GradeBook.repository.SubjectRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository repo;

    @Override
    public void save(Subject subject) {
        repo.save(subject);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Subject> findAll() {
        return repo.findAll();
    }

}
