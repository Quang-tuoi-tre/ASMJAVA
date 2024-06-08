package mu.ronaldo.lienquan.Asm.controller;

import jakarta.validation.Valid;
import mu.ronaldo.lienquan.Asm.Service.CategoryService;
import mu.ronaldo.lienquan.Asm.Service.CourseService;
import mu.ronaldo.lienquan.Asm.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/course")
public class CourseController {
 @Autowired
    private CourseService courseService;

 private CategoryService categoryService;
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("courses", new Course());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "hello";
    }
    // Process the form for adding a new Course
    @PostMapping("/add")
    public String addCourse(@Valid Course Course, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("Courses", Course);
            model.addAttribute("categories", categoryService.getAllCategories());
            return "create";
        }
//        CourseService.updateImage(Course,imageCourse);
        courseService.addCourse(Course);
        return "redirect:/course";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Course course = courseService.getCourseById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
        model.addAttribute("courses", course);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "update";
    }
    // Process the form for updating a product
    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable Integer id, @Valid Course course,
                                BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            course.setId(id);
            model.addAttribute("courses", course);
            model.addAttribute("categories", categoryService.getAllCategories());
// set id to keep it in the form in case of errors
            return "update";
        }
        courseService.updateCourse(course);
        return "redirect:/home";
    }
    // Handle request to delete a product
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        courseService.deleteProductById(id);
        return "redirect:/home";
    }

}