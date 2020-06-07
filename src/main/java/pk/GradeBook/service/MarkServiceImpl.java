package pk.GradeBook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.GradeBook.model.Mark;
import pk.GradeBook.repository.MarkRepository;

import java.util.List;

@Service
public class MarkServiceImpl implements MarkService{

    @Autowired
    private MarkRepository repo;

    @Override
    public void save(Mark   mark) {
        repo.save(mark);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Mark findById(Long id) {
        if (repo.findById(id).isPresent()) {
            return repo.findById(id).get();
        }
        else{
            return new Mark();
        }
    }

    @Override
    public List<Mark> findAll() {
        return repo.findAll();
    }

}
