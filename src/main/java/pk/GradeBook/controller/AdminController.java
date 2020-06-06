package pk.GradeBook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pk.GradeBook.model.User;
import pk.GradeBook.service.UserService;
import pk.GradeBook.util.Roles;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {

    private static final String prePathManagement = "Admin/AdminManagement/";

    @Autowired
    UserService userService;

    @RequestMapping()
    private String startPage(Model model){
        return prePathManagement + "startAdmin";
    }

    @RequestMapping("/management")
    private String managementPage(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return prePathManagement + "managementAdmin";
    }

    @RequestMapping("/newUser")
    private String createNewUser(Model model){
        List<String> role = Arrays.asList(Roles.ROLE_STUDENT, Roles.ROLE_TEACHER, Roles.ROLE_ADMIN);
        List<String> roleName = Arrays.asList(Roles.ROLE_STUDENT_NAME, Roles.ROLE_TEACHER_NAME, Roles.ROLE_ADMIN_NAME);
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("role", role);
        model.addAttribute("roleName", roleName);
        return prePathManagement + "newUserAdmin";
    }

    @RequestMapping("/editUser/{id}")
    private String editUser(@PathVariable("id") long id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return prePathManagement + "editUserAdmin";
    }

    @RequestMapping("/saveUser")
    private String saveUser(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:/admin/management";
    }

    @RequestMapping("/deleteUser/{id}")
    private String deleteUser(@PathVariable("id") long id, Model model){
        userService.deleteById(id);
        return "redirect:/admin/management";
    }

    @RequestMapping("/subjects")
    private String subjectsPage(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return prePathManagement + "subjectsAdmin";
    }
}