package pk.GradeBook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("student")
public class StudentController {

    @RequestMapping()
    private String startPage(Model model){
        return "startStudent";
    }
}