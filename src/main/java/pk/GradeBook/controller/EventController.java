package pk.GradeBook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pk.GradeBook.model.Event;
import pk.GradeBook.repository.EventRepository;

import java.util.List;

@RequestMapping("/events")
@Controller
public class EventController {

    //TODO: service instead of repo
    @Autowired
    private EventRepository repo;

    @GetMapping("/test")
    private String listEvents(Model model){
        List<Event> eventList = repo.findAll();
        model.addAttribute("events", eventList);
        return "events";
    }
}
