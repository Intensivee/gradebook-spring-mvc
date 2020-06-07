package pk.GradeBook.service;

import pk.GradeBook.model.Event;

import java.util.List;

public interface EventService {

    void save(Event event);

    void deleteById(Long id);

    Event findById(Long id);

    List<Event> findAll();

}
