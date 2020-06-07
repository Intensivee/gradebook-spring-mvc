package pk.GradeBook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.GradeBook.model.Event;
import pk.GradeBook.repository.EventRepository;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventRepository repo;

    @Override
    public void save(Event event) {
        repo.save(event);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Event findById(Long id) {
        if (repo.findById(id).isPresent()) {
            return repo.findById(id).get();
        }
        else{
            return new Event();
        }
    }

    @Override
    public List<Event> findAll() {
        return repo.findAll();
    }
}
