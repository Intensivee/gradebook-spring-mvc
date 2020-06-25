package pk.GradeBook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.GradeBook.model.Mark;
import pk.GradeBook.model.Subject;
import pk.GradeBook.model.User;
import pk.GradeBook.repository.MarkRepository;

import java.util.ArrayList;
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

    @Override
    public List<Mark> fetchSubjectMarks(List<Mark> marks, Long subjectId) {
        List<Mark> fetchedMarks = new ArrayList<>();
        for(Mark mark : marks)
            if(mark.getSubjectId().equals(subjectId))
                fetchedMarks.add(mark);
        return fetchedMarks;
    }

    @Override
    public int maxMarksInSubjectStudents(Subject subject) {
        int maxMarksNumber = 1;
        int temp;

        for(User user : subject.getUsers()){
            temp = this.fetchSubjectMarks(user.getMarks(), subject.getSubjectId()).size();
            if(temp > maxMarksNumber)
                maxMarksNumber = temp;
        }
        return maxMarksNumber;
    }
}
