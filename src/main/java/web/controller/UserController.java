package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // localhost:8080/users
    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userService.findAll());

        return "index";
    }

    // localhost:8080/users/user?id=1
    @GetMapping("/user")
    public String getUserById(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.findById(id));

        return "show";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());

        return "new";
    }

    @PostMapping("/new")
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }
        userService.saveUser(user);

        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") int id) {
        userService.delete(id);

        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.findById(id));

        return "edit";
    }

    @PostMapping("/edit")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, @RequestParam("id") int id) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        userService.update(id, user);

        return "redirect:/users";
    }
}