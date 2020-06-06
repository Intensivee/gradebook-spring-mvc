package pk.GradeBook.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pk.GradeBook.model.Event;
import pk.GradeBook.model.MyUserDetails;
import pk.GradeBook.model.Subject;
import pk.GradeBook.model.User;
import pk.GradeBook.repository.EventRepository;
import pk.GradeBook.repository.SubjectRepository;
import pk.GradeBook.service.UserService;

@Controller
@RequestMapping("teacher")
public class TeacherController {

    private static final Logger log = LoggerFactory.getLogger(TeacherController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private EventRepository eventRepository;

    @RequestMapping()
    private String startPage(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails loggedUser = (MyUserDetails)authentication.getPrincipal();
        User user = userService.findById(loggedUser.getUserId());

        model.addAttribute("subjects", user.getSubjects());
        model.addAttribute("chosenSubject", new Subject());
        return "startTeacher";
    }


//    EVENTS CONTROLLERS

    @RequestMapping("/eventManagement/{id}")
    private String eventPage(@PathVariable("id") Long subjectId, Model model){
        Subject subject = subjectRepository.getOne(subjectId);
        model.addAttribute("subject", subject);
        model.addAttribute("events", subject.getEvents());
        model.addAttribute("newEvent", new Event());
        return "eventsManagement";
    }

    @RequestMapping("/deleteEvent/{id}")
    private String deleteEvent(@PathVariable("id") long eventId){
        Long subjectId = eventRepository.getOne(eventId).getSubjectId();
        eventRepository.deleteById(eventId);
        return "redirect:/teacher/subject/" + subjectId;
    }

    @RequestMapping("/saveEvent")
    private String saveEvent(@ModelAttribute("event") Event event){
        eventRepository.save(event);
        Long subjectId = event.getSubjectId();
        return "redirect:/teacher/subject/" + subjectId;
    }

//    ATTENDANCE CONTROLLERS

    @RequestMapping("/attendanceManagement/{id}")
    private String attendancePage(@PathVariable("id") Long subjectId, Model model){
        model.addAttribute("subject", subjectRepository.getOne(subjectId));
        return "attendanceManagement";
    }



//    MARKS CONTROLLERS

    @RequestMapping("/markManagement/{id}")
    private String marksPage(@PathVariable("id") Long subjectId, Model model){
        model.addAttribute("subject", subjectRepository.getOne(subjectId));
        return "marksManagement";
    }
}
