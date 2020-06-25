package pk.GradeBook.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pk.GradeBook.model.*;
import pk.GradeBook.service.*;
import pk.GradeBook.util.Factory;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("teacher")
public class TeacherController {

    private static final Logger log = LoggerFactory.getLogger(TeacherController.class);
    private static final String prePath = "teacher/";

    @Autowired
    private Factory factory;

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


    @GetMapping()
    private String startPage(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails loggedUser = (MyUserDetails)authentication.getPrincipal();
        User user = userService.findById(loggedUser.getUserId());

        model.addAttribute("subjects", user.getSubjects());
        model.addAttribute("chosenSubject", factory.newSubject());
        return prePath + "startTeacher";
    }


//    EVENTS CONTROLLERS

    @GetMapping("/eventManagement/{id}")
    private String eventPage(@PathVariable("id") Long subjectId, Model model){
        Subject subject = subjectService.findById(subjectId);
        model.addAttribute("subject", subject);
        model.addAttribute("events", subject.getEvents());
        model.addAttribute("newEvent",  factory.newEvent());
        return prePath + "eventsManagement";
    }

    @GetMapping("/deleteEvent/{id}")
    private String deleteEvent(@PathVariable("id") long eventId){
        Long subjectId = eventService.findById(eventId).getSubjectId();
        eventService.deleteById(eventId);
        return "redirect:/teacher/eventManagement/" + subjectId;
    }

    @PostMapping("/saveEvent")
    private String saveEvent(@ModelAttribute("event") Event event){
        eventService.save(event);
        Long subjectId = event.getSubjectId();
        return "redirect:/teacher/eventManagement/" + subjectId;
    }



//    ATTENDANCE CONTROLLERS

    @GetMapping("/attendanceManagement/{id}")
    private String attendancePage(@PathVariable("id") Long subjectId, Model model){
        Subject subject = subjectService.findById(subjectId);
        List<User> users = subject.getUsers();
//      finding out how many columns for attendances should be in view.
        int maxAttendanceNumber = users.get(0).getAttendances().size();

        List<Attendance> attendances = users.get(0).getAttendances();
        model.addAttribute("maxAttendanceNumber", maxAttendanceNumber);
        model.addAttribute("subject", subject);
        model.addAttribute("attendances", attendanceService.fetchSubjectAttendances(attendances, subjectId));

        return prePath + "attendanceManagement";
    }

    @GetMapping("/attendanceEdit/{subjectId}/{LessonNumber}")
    private String attendanceEdit(@PathVariable("subjectId") Long subjectId, @PathVariable("LessonNumber") int lessonNumber, Model model){
        Subject subject = subjectService.findById(subjectId);
        List<User> users = subject.getUsers();
        users = userService.fetchStudentUsers(users);
        model.addAttribute("users", users);
        List<List<Attendance>> attendances = new ArrayList<>();
        for(User user : users)
            attendances.add(attendanceService.fetchSubjectAttendances(user.getAttendances(), subjectId));

        model.addAttribute("attendances", attendances);
        model.addAttribute("subject", subject);
        model.addAttribute("LessonNumber", lessonNumber);
        return prePath + "EditAttendance";
    }

    @GetMapping("attendanceSwitch/{subjectId}/{LessonNumber}/{attendanceId}")
    private String switchAttendance(@PathVariable("subjectId") Long subjectId,
                                    @PathVariable("LessonNumber") Long LessonNumber,
                                    @PathVariable("attendanceId") Long attendanceId,
                                    Model model){
        Subject subject = subjectService.findById(subjectId);
        Attendance attendance = attendanceService.findById(attendanceId);
        attendanceService.switchPresence(attendance);
        attendanceService.save(attendance);
        return "redirect:/teacher/attendanceEdit/" + subjectId + "/" + LessonNumber;
    }

    @GetMapping("newAttendance/{subjectId}")
    private String newLesson(@PathVariable("subjectId") Long subjectId, Model model){
        Subject subject = subjectService.findById(subjectId);
        List<User> users = subject.getUsers();
        users = userService.fetchStudentUsers(users);

        for (User user : users) {
            Attendance attendance = factory.newAttendance();
            attendance.setPresence(0);
            attendance.setUserId(user.getUserId());
            attendance.setSubjectId(subjectId);
            attendanceService.save(attendance);
        }

//        getting attendances of first user in subject
        List<Attendance> userAttendances = users.get(0).getAttendances();
//        getting attendances of specified subject
        userAttendances = attendanceService.fetchSubjectAttendances(userAttendances, subjectId);
//        getting index of last attendance (new lesson)
        int lessonNumber = userAttendances.size() - 1;
        model.addAttribute("users", users);
        model.addAttribute("subject", subject);
        return "redirect:/teacher/attendanceEdit/" + subjectId + "/" + lessonNumber;
    }




//    MARKS CONTROLLERS

    @GetMapping({"/markManagement/{subjectId}", "/markManagement/{subjectId}/{userId}"})
    private String marksPage(@PathVariable("subjectId") Long subjectId, @PathVariable(required = false, value = "userId") Long userId, Model model){
        Subject subject = subjectService.findById(subjectId);
        model.addAttribute("subject", subject);
        List<User> users = subject.getUsers();
        model.addAttribute("users", userService.fetchStudentUsers(users));

//      not required value (if present, view show add new mark to specified user)
        if(userId != null){
            model.addAttribute("addMarkUserId", userId);
            Mark newMark = factory.newMark();
            newMark.setUserId(userId);
            newMark.setSubjectId(subjectId);
            model.addAttribute("mark", newMark);
        }

//      finding out how many columns for marks should be in view.
        int maxMarksNumber = markService.maxMarksInSubjectStudents(subject);
        model.addAttribute("maxMarksNumber", maxMarksNumber);
        return prePath + "marksManagement";
    }

    @GetMapping("/deleteMark/{subjectId}/{markId}")
    private String deleteMark(@PathVariable("subjectId") Long subjectId, @PathVariable("markId") Long markId){
        markService.deleteById(markId);
        return "redirect:/teacher/markManagement/" + subjectId;
    }

    @PostMapping("/addMark")
    private String addMark(@ModelAttribute("mark") Mark mark){
        markService.save(mark);
        return "redirect:/teacher/markManagement/" + mark.getSubjectId();
    }
}
