package mu.ronaldo.lienquan.Asm.controller;

import jakarta.validation.Valid;
import mu.ronaldo.lienquan.Asm.Repository.UserRepository;
import mu.ronaldo.lienquan.Asm.Service.CategoryService;
import mu.ronaldo.lienquan.Asm.Service.CourseService;
import mu.ronaldo.lienquan.Asm.model.Course;
import mu.ronaldo.lienquan.Asm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;


@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private  UserRepository userRepository;

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
    public String addCourse(@Valid @ModelAttribute("course") Course course, BindingResult result, Model model) {

        if (result.hasErrors()) {

            model.addAttribute("categories", categoryService.getAllCategories());
            return "create";
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            LocalDateTime startDate = LocalDateTime.parse(course.getStartDateStr(), formatter);
            course.setStartDate(startDate);
        } catch (DateTimeParseException e) {
            result.rejectValue("startDateStr", "error.course", "Invalid date format. Please use dd/MM/yyyy HH:mm.");
            model.addAttribute("categories", categoryService.getAllCategories());
            return "create";
        }

        String username = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        User loggedInUser = userRepository.findByUsername(username);
        course.setLecture(loggedInUser);

        courseService.addCourse(course);
        return "redirect:/home";
    }

   /* @PostMapping("/add")
    public String addCourse(@Valid @ModelAttribute Course Course, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categories", categoryService.getAllCategories());

            return "create";
        }
        courseService.addCourse(Course);
        return "redirect:/course";
    }*/

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Course course = courseService.getCourseById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
        course.setStartDateStr(course.getStartDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        model.addAttribute("course", course);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "update";
    }
    // Process the form for updating a product
    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id, @Valid Course course,
                                BindingResult result,
                                Model model) {
        List<User> lecturers = userRepository.findAll();

        if (result.hasErrors()) {
            course.setId(id);
            model.addAttribute("course", course);
            model.addAttribute("categories", categoryService.getAllCategories());
            model.addAttribute("lecturers", lecturers);
            return "update";
        }

        // Convert startDateStr to LocalDateTime and set it to startDate
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            LocalDateTime startDate = LocalDateTime.parse(course.getStartDateStr(), formatter);
            course.setStartDate(startDate);
        } catch (DateTimeParseException e) {
            result.addError(new FieldError("course", "startDateStr", "Invalid date format"));
            model.addAttribute("course", course);
            model.addAttribute("categories", categoryService.getAllCategories());
            return "update";
        }

        courseService.updateCourse(course);
        return "redirect:/home";
    }
    // Handle request to delete a product
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        courseService.deleteProductById(id);
        return "redirect:/home";
    }

}