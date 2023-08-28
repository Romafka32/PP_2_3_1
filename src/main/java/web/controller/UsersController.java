package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.UserService;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class UsersController {

    UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getCars(ModelMap model) {
        model.addAttribute("userlist", userService.getAllUsers());
        return "users/users";
    }
}
