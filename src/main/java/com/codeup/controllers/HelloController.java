package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller //dictates that this class is a controller (in MVC)
public class HelloController {
//    @GetMapping("/hello/{name}") //when GET request to "localhost:8080/", run the method directly beneath this
//    @ResponseBody //Also returns the method return String as HTML
//    public String hello(@PathVariable String name){
//        return "Hello from Spring, " +name+ "!";
//    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("pageTitle", "Hello page");
        return "hello";
    }



    @GetMapping("/join")
    public String showJoinForm(Model model) {
        model.addAttribute("pageTitle", "Join page");
        return "join";
    }


    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
        model.addAttribute("pageTitle", "Join page");
        return "join";
    }

    @GetMapping("/welcome")
    public String welcome(Model model){
        model.addAttribute("pageTitle", "Welcome page");
        return "welcome";
    }




//@GetMapping("/")
//    public String index(){
//    return "This is the index page~";
//}
}

