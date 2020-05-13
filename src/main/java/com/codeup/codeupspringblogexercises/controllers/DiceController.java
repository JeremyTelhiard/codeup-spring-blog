package com.codeup.codeupspringblogexercises.controllers;

import com.codeup.codeupspringblogexercises.controllers.models.Die;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Random;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String landingPage(){
        return "/roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String rolleDice(@PathVariable String n,
                            Model model){
        Random random = new Random();
        int randomNum = 0;
        String outcome = "";
        ArrayList<Die> rolls = new ArrayList<>();
        ArrayList<String> outcomes = new ArrayList<>();
        model.addAttribute("guess", n);
        int guess = Integer.parseInt(n);
        for(int i = guess; i>0; i--){
            randomNum = random.nextInt( 7 - 1) + 1;
            if(randomNum == guess){
                outcome = "Hey, ya got it, congrats!";
            } else {
                outcome = "Nope, not a lucky roll this time, didn't get it!";
            }
            Die die = new Die(randomNum, outcome);
            rolls.add(die);
        }
        model.addAttribute("rolls", rolls);
        return "roll-dice";
    }

}

//    @GetMapping("/ads/create")
//    public String goToCreateAdsForm(Model model){
//        return "ads/create";
//    }
//
//    @PostMapping("/ads/create")
//    public String createAd(@RequestParam(name = "title") String title,
//                           @RequestParam(name ="description") String description,
//                           Model model){
//        Ad ad = new Ad(title, description);
//        model.addAttribute("ad", ad);
//        return "ads/show";
//    }
