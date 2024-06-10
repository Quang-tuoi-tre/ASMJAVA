package mu.ronaldo.lienquan.Asm.controller;

import jakarta.validation.Valid;
import mu.ronaldo.lienquan.Asm.Service.CategoryService;
import mu.ronaldo.lienquan.Asm.Service.CourseService;
import mu.ronaldo.lienquan.Asm.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Controller
@RequestMapping("/course")
public class CourseController {
 @Autowired

    private CourseService courseService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public String showCourseList(Model model) {

        model.addAttribute("courses", courseService.getAllCourse());
        return "home";
    }
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("categories", categoryService.getAllCategories());

        return "create";
    }
    // Process the form for adding a new Course
    @PostMapping("/add")
    public String addCourse( Course Course, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("courses", Course);
            model.addAttribute("categories", categoryService.getAllCategories());

            return "create";
        }
        courseService.addCourse(Course);
        return "redirect:/course";
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Course course = courseService.getCourseById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
        model.addAttribute("course", course);
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
        return "redirect:/course";
    }
    // Handle request to delete a product
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        courseService.deleteProductById(id);
        return "redirect:/course";
    }

}