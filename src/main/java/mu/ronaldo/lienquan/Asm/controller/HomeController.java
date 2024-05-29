package mu.ronaldo.lienquan.Asm.controller;


import mu.ronaldo.lienquan.Asm.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/test")
    public String index() {
        return "home";
    }

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("courses", courseService.GetAll());
        model.addAttribute("courseService", courseService);
        return "home";
    }
}