package mu.ronaldo.lienquan.Asm.controller;

import mu.ronaldo.lienquan.Asm.Service.CourseService;
import mu.ronaldo.lienquan.Asm.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/course")
public class CourseController {
 @Autowired
    private CourseService courseService;
    @GetMapping("/create")
    public String create(Model model){

        model.addAttribute(  "course", new Course());
return "create";}

@PostMapping("/create")
public String create(Course course, Model model){
    LocalDate now = LocalDate.now();
    DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
    if (course.getStartDate().isBefore(now)) {
        model.addAttribute("error", "Start Date must be after the current date.");
        return "create";
    }
    courseService.add(course);
    return "redirect:/home";
}

}