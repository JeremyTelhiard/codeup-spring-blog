package com.codeup;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //dictates that this class is a controller (in MVC)
public class HelloController {
    @GetMapping("/") //when GET request to "localhost:8080/", run the method directly beneath this
    @ResponseBody //Also returns the method return String as HTML
    public String hello(){
        return "Hello from Spring!";
    }

//@GetMapping("/")
//    public String index(){
//    return "This is the index page~";
//}
}

