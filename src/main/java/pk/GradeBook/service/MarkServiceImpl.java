package pk.GradeBook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.GradeBook.repository.MarkRepository;

@Service
public class MarkServiceImpl implements MarkService{

    @Autowired
    private MarkRepository repo;

}
