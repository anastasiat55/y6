package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static java.lang.System.*;

@Controller
public class UserController {

    @Autowired
    private org.example.userService userService;

    public UserController(org.example.userService userService) {
        this.userService = userService;
    }

    // Показати сторінку зі списком користувачів і формою додавання
    @GetMapping("/users")
    public String usersPage(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("newUser", new User());
        return "users"; // Ім'я thymeleaf шаблону (users.html)
    }

    // Обробка додавання нового користувача
    @PostMapping("/add")
    public String addUser(@ModelAttribute("newUser") User user) {
        out.println(StringTemplate.STR."Adding user: \{user.getName()}, \{user.getEmail()}");
        userService.saveUser(user);
        return "redirect:/users";
    }

    // Обробка видалення користувача за id
    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
