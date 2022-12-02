package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;


@Controller
@RequestMapping("/")
public class UserController {

    @GetMapping("/login")
    public String loginPage() {
        return "loginPage";
    }

    @GetMapping("/user")
    public String showUser(Model model, Principal principal) {
        return "user";
    }
}
