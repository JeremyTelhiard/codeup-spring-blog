package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @GetMapping("/add/{n1}/and/{n2}")
    @ResponseBody
    public String adding(@PathVariable int n1, @PathVariable int n2){
        return "Those numbers added together equals " + (n1 + n2) + "!!!";
    }

    @GetMapping("/subtract/{n1}/and/{n2}")
    @ResponseBody
    public String subtracting(@PathVariable int n1, @PathVariable int n2){
        return "Those numbers subtracted from each other equals " + (n1 - n2) + "!!!";
    }

    @GetMapping("/multiply/{n1}/and/{n2}")
    @ResponseBody
    public String multiplying(@PathVariable int n1, @PathVariable int n2){
        return "Those numbers multiplied together equals " + (n1 * n2) + "!!!";
    }

    @GetMapping("/divide/{n1}/and/{n2}")
    @ResponseBody
    public String dividing(@PathVariable double n1, @PathVariable double n2){
        return "Those numbers divided equals " + (n1 / n2 ) + "!!!";
    }
}
