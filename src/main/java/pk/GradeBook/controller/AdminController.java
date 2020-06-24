package pk.GradeBook.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pk.GradeBook.model.Subject;
import pk.GradeBook.model.User;
import pk.GradeBook.service.SubjectService;
import pk.GradeBook.service.UserService;
import pk.GradeBook.util.Factory;
import pk.GradeBook.util.Roles;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {

    private static final Logger log = LoggerFactory.getLogger(AdminController.class);

    private static final String prePathManagement = "Admin/UserManagement/";
    private static final String prePathUserSubjectManagement = "Admin/SubjectManagement/";
    @Autowired
    private UserService userService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private Factory factory;

    @RequestMapping()
    private String startPage(Model model){
        return "admin/start";
    }

    @RequestMapping("/user-management")
    private String managementPage(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return prePathManagement + "management";
    }

    @RequestMapping("/newUser")
    private String createNewUser(Model model){
        List<String> role = Arrays.asList(Roles.ROLE_STUDENT, Roles.ROLE_TEACHER, Roles.ROLE_ADMIN);
        List<String> roleName = Arrays.asList(Roles.ROLE_STUDENT_NAME, Roles.ROLE_TEACHER_NAME, Roles.ROLE_ADMIN_NAME);
        User user = factory.newUser();
        model.addAttribute("user", user);
        model.addAttribute("role", role);
        model.addAttribute("roleName", roleName);
        return prePathManagement + "newUser";
    }

    @RequestMapping("/editUser/{id}")
    private String editUser(@PathVariable("id") Long id, Model model){
        List<String> role = Arrays.asList(Roles.ROLE_STUDENT, Roles.ROLE_TEACHER, Roles.ROLE_ADMIN);
        List<String> roleName = Arrays.asList(Roles.ROLE_STUDENT_NAME, Roles.ROLE_TEACHER_NAME, Roles.ROLE_ADMIN_NAME);
        User user = userService.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("role", role);
        model.addAttribute("roleName", roleName);
        return prePathManagement + "editUser";
    }

    @RequestMapping("/saveUser")
    private String saveUser(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:/admin/user-management";
    }

    @RequestMapping("/deleteUser/{id}")
    private String deleteUser(@PathVariable("id") Long id){
        userService.deleteById(id);
        return "redirect:/admin/user-management";
    }

    @RequestMapping(value = {"/subject-management", "/subject-management/{id}"})
    private String subjectManagementPage(@PathVariable(required = false) Long id, Model model){
        if(id != null)
        {
            User user = userService.findById(id);
            model.addAttribute("userSubjects", user.getSubjects());
        }

        List<User> users = userService.findAll();
        model.addAttribute("users", users);

        Subject addSubject =  factory.newSubject();
        model.addAttribute("subject", addSubject);

        List<Subject> subjects = subjectService.findAll();
        model.addAttribute("subjects", subjects);

        return prePathUserSubjectManagement + "management";
    }

    @RequestMapping("/deleteSubject/{id}")
    private String deleteSubject(@PathVariable("id") Long id){
        subjectService.deleteById(id);
        return "redirect:/admin/subject-management";
    }

    @RequestMapping("/saveSubject")
    private String saveSubject(@ModelAttribute("subject") Subject subject){
        subjectService.save(subject);
        return "redirect:/admin/subject-management";
    }

    @RequestMapping("/joinUserSubject/{id}")
    private String joinUserSubjectPanel(@PathVariable("id") Long id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);

        Subject addSubject = factory.newSubject();
        model.addAttribute("subject", addSubject);

        List<Subject> subjects = subjectService.findAll();
        model.addAttribute("subjects", subjects);

        return prePathUserSubjectManagement + "joinUserSubject";
    }

    @RequestMapping("/addUserSubject/{userId}/{subjectId}")
    private String addUserSubject(@PathVariable("userId") Long userId, @PathVariable("subjectId") Long subjectId, Model model){
        User user = userService.findById(userId);

        Subject subject = subjectService.findById(subjectId);
        userService.addSubject(user, subject);
        userService.save(user);
        return "redirect:/admin/joinUserSubject/" + userId;
    }

    @RequestMapping("/delUserSubject/{userId}/{subjectId}")
    private String delUserSubject(@PathVariable("userId") Long userId, @PathVariable("subjectId") Long subjectId, Model model){
        User user = userService.findById(userId);
        Subject subject = subjectService.findById(subjectId);
        userService.deleteSubject(user, subject);
        userService.save(user);
        return "redirect:/admin/joinUserSubject/" + userId;
    }
}