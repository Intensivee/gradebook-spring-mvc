package pk.GradeBook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pk.GradeBook.model.UserSubject;
import pk.GradeBook.repository.UserSubjectRepository;

@Controller
@RequestMapping ("/userSubject")
public class UserSubjectController {

    @Autowired
    private UserSubjectRepository repo;

    @GetMapping("/test")
    private String test(Model model){
        model.addAttribute("usersSubjects", repo.findAll());
        return "userSubject";
    }
}
