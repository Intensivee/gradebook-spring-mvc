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
import pk.GradeBook.repository.MarkRepository;
import pk.GradeBook.service.SubjectService;
import pk.GradeBook.service.UserService;

@Controller
@RequestMapping("teacher")
public class TeacherController {

    private static final Logger log = LoggerFactory.getLogger(TeacherController.class);
    private static final String prePath = "teacher/";

    @Autowired
    private UserService userService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private MarkRepository markRepository;


    @RequestMapping()
    private String startPage(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails loggedUser = (MyUserDetails)authentication.getPrincipal();
        User user = userService.findById(loggedUser.getUserId());

        model.addAttribute("subjects", user.getSubjects());
        model.addAttribute("chosenSubject", new Subject());
        return prePath + "startTeacher";
    }


//    EVENTS CONTROLLERS

    @RequestMapping("/eventManagement/{id}")
    private String eventPage(@PathVariable("id") Long subjectId, Model model){
        Subject subject = subjectService.findById(subjectId);
        model.addAttribute("subject", subject);
        model.addAttribute("events", subject.getEvents());
        model.addAttribute("newEvent", new Event());
        return prePath + "eventsManagement";
    }

    @RequestMapping("/deleteEvent/{id}")
    private String deleteEvent(@PathVariable("id") long eventId){
        Long subjectId = eventRepository.getOne(eventId).getSubjectId();
        eventRepository.deleteById(eventId);
        return "redirect:/teacher/eventManagement/" + subjectId;
    }

    @RequestMapping("/saveEvent")
    private String saveEvent(@ModelAttribute("event") Event event){
        eventRepository.save(event);
        Long subjectId = event.getSubjectId();
        return "redirect:/teacher/eventManagement/" + subjectId;
    }

//    ATTENDANCE CONTROLLERS

    @RequestMapping("/attendanceManagement/{id}")
    private String attendancePage(@PathVariable("id") Long subjectId, Model model){
        model.addAttribute("subject", subjectService.findById(subjectId));
        return prePath + "attendanceManagement";
    }



//    MARKS CONTROLLERS

    @RequestMapping("/markManagement/{id}")
    private String marksPage(@PathVariable("id") Long subjectId, Model model){
        Subject subject = subjectService.findById(subjectId);
        model.addAttribute("subject", subject);
        model.addAttribute("users",subject.getUsers());

//      finding out how many columns for marks should be in view.
        int maxMarksNumber = 0;
        for(User user : subject.getUsers()){
            if(user.getMarks().size() > maxMarksNumber){
                maxMarksNumber = user.getMarks().size();
            }
        }
        if (maxMarksNumber < 1){
            maxMarksNumber = 1;
        }
        log.info("ilosc ocen: {}", maxMarksNumber);
        model.addAttribute("maxMarksNumber", maxMarksNumber);
        return prePath + "marksManagement";
    }

    @RequestMapping("/deleteMark/{subjectId}/{markId}")
    private String deleteMark(@PathVariable("subjectId") Long subjectId, @PathVariable("markId") Long markId){
        markRepository.deleteById(markId);
        return "redirect:/teacher/markManagement/" + subjectId;
    }

    @RequestMapping("/addMark/{id}")
    private String addMark(@PathVariable("id") Long userId){
        return "Todo";
    }
}
