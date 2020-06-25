package pk.GradeBook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pk.GradeBook.model.Attendance;
import pk.GradeBook.model.MyUserDetails;
import pk.GradeBook.model.Subject;
import pk.GradeBook.model.User;
import pk.GradeBook.service.*;
import pk.GradeBook.util.Factory;

import java.util.List;

@Controller
@RequestMapping("student")
public class StudentController {

    private static final String prePath = "Student/";

    @Autowired
    private UserService userService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private EventService eventService;

    @Autowired
    private MarkService markService;

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private Factory factory;

    @GetMapping("/events")
    private String eventPage(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails loggedUser = (MyUserDetails)authentication.getPrincipal();

        User user = userService.findById(loggedUser.getUserId());
        model.addAttribute("user", user);

        List<Subject> subjects = user.getSubjects();
        model.addAttribute("subjects", subjects);

        return prePath + "events";
    }

    @GetMapping("/marks")
    private String markPage(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails loggedUser = (MyUserDetails)authentication.getPrincipal();

        User user = userService.findById(loggedUser.getUserId());
        model.addAttribute("user", user);

        List<Subject> subjects = user.getSubjects();
        model.addAttribute("subjects", subjects);
        model.addAttribute("marksLen", userService.getMarksLenBySubjectId(subjects, user));
        return prePath + "marks";
    }

    @GetMapping("/attendances")
    private String attendancePage(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails loggedUser = (MyUserDetails)authentication.getPrincipal();

        User user = userService.findById(loggedUser.getUserId());
        model.addAttribute("user", user);

        List<Attendance> attendances = user.getAttendances();
        model.addAttribute("attendances", attendances);

        model.addAttribute("attendanceLen", user.getMarks().size());

        return prePath + "attendance";
    }
}