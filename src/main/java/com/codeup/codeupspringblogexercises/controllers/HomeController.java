package com.codeup.codeupspringblogexercises.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String welcome(Model model) {
        model.addAttribute("pageTitle", "Home page");
        return "home";
    }
}