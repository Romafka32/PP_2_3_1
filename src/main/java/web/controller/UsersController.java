package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/")
public class UsersController {

    UserService userService;

    private UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUsers(ModelMap model) {
        model.addAttribute("userlist", userService.getAllUsers());
        return "users/users";
    }

    @GetMapping("/{id}")
    public String getOneUser(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("user", userService.getOneUser(id));
        return "users/id";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "users/new";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("user", userService.getOneUser(id));
        return "users/edit";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user")User user, @PathVariable("id") Long id) {
        userService.updateUser(id, user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser( @PathVariable("id") Long id) {
        userService.removeUserById(id);
        return "redirect:/";
    }
}
