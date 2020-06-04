package pk.GradeBook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pk.GradeBook.model.Subject;
import pk.GradeBook.repository.SubjectRepository;

@Controller
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectRepository repo;

    @GetMapping("/test")
    private String test(Model model){
        model.addAttribute("subjects", repo.findAll());
        return "subject";
    }
}
