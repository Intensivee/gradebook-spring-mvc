package pk.GradeBook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.GradeBook.repository.SubjectRepository;

@Service
public class SubjectServiceImpl {
    @Autowired
    private SubjectRepository repo;
}
