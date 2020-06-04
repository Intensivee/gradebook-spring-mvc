package pk.GradeBook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.GradeBook.repository.UserSubjectRepository;

@Service
public class UserSubjectServiceImpl implements UserSubjectService{
    @Autowired
    private UserSubjectRepository repo;
}
