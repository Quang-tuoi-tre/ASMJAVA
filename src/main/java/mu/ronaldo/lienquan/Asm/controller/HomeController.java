package mu.ronaldo.lienquan.Asm.controller;


import mu.ronaldo.lienquan.Asm.Service.CategoryService;
import mu.ronaldo.lienquan.Asm.Service.CourseService;
import mu.ronaldo.lienquan.Asm.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Controller
//@RequestMapping("/home")
public class HomeController {
    @Autowired

    private CourseService courseService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/home")
    public String showCourseLists(Model model) {
        List<Course> allCourses = courseService.getAllCourse();

        // Lọc các khóa học sắp tới (startDater3 sau thời điểm hiện tại)
        LocalDateTime now = LocalDateTime.now();
        List<Course> upcomingCourses = allCourses.stream()
                .filter(course -> course.getStartDate().isAfter(now))
                .collect(Collectors.toList());

        model.addAttribute("courses", upcomingCourses);
        return "Course-list";
    }
    @RequestMapping(value = "/search")
    public String listCourses(@RequestParam(name = "search", required = false) String search, Model model) {
        List<Course> courses;
        if (search != null && !search.isEmpty()) {
            courses = courseService.findByLectureNameContaining(search);
        } else {
            courses = courseService.getAllCourse();
        }
        model.addAttribute("courses", courses);
        return "Course-list"; // Tên view của trang chủ
    }
}

//    @GetMapping("")
//    public String index(Model model) {
//        model.addAttribute("courses", courseService.GetAll());
//        model.addAttribute("courseService", courseService);
//        return "home";
//    }
//}
