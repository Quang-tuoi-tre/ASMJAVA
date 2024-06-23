package mu.ronaldo.lienquan.Asm.controller;

import jakarta.validation.Valid;
import mu.ronaldo.lienquan.Asm.model.User;
import mu.ronaldo.lienquan.Asm.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result,Model model) {
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }

        // Save user to database (assuming UserRepository.save() method)
        userRepository.save(user);

        // Redirect to addcourse page on successful registration
        return "redirect:/course/add";
    }
}
