package pk.GradeBook.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pk.GradeBook.model.Mark;
import pk.GradeBook.repository.MarkRepository;

import java.util.List;

@Controller
@RequestMapping("admin/mark")
public class MarkController {

    //TODO: service instead of repo
    @Autowired
    private MarkRepository repo;

    public static final Logger log = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/test")
    public String listMarks(Model model){
        List<Mark> markList = repo.findAll();
        model.addAttribute("marks", markList);
        return "mark";
    }
}
