package pk.GradeBook.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pk.GradeBook.model.User;
import pk.GradeBook.service.UserService;

import java.util.List;

@Controller
public class UserController {

    public static final Logger log = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private UserService service;

    @RequestMapping("/")
    private String UsersList(Model model){
        List<User> userList = service.listAll();
        model.addAttribute("users", userList);
        return "user";
    }

    @RequestMapping("/newUser")
    private String createNewUser(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }

    @RequestMapping("/editUser/{id}")
    private String editUser(@PathVariable("id") long id, Model model){
        User user = service.get(id);
        model.addAttribute("user", user);
        return "edit_user";
    }

    @RequestMapping("/deleteUser/{id}")
    private String deleteUser(@PathVariable("id") long id, Model model){
        service.delete(id);
        return "redirect:/";
    }

    @PostMapping("/saveUser")
    private String saveUser(@ModelAttribute("user") User user){
        service.save(user);
        return "redirect:/";
    }
}
