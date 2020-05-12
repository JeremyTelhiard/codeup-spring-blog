package com.codeup.controllers;


import models.Ad;
import models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String postsIndex(Model model){
        List<Post> posts = new ArrayList<>();
        Post post = new Post("My awesome lifehacks", "Jane D.", "Just keep on smiling~ Just keep on smiling~ Just " +
                "keep on smiling~ Just keep on smiling~ Just keep on smiling~ Just keep on smiling~ Just keep on smiling~ ");
        posts.add(post);
        post = new Post("I'm a sad doggo", "Pupper76",
                "WoofbarkbarkwoofwhineWoofbarkbarkwoofwhineWoofbarkbarkwoofwhineWoofbarkbarkwoofwhine");
        posts.add(post);
        model.addAttribute("posts", posts);
        return "posts/index";
    }


    @GetMapping("/post")
    public String singlePosting(Model model){
        Post post = new Post("My awesome lifehacks", "Jane D.", "Just keep on smiling~ Just keep on smiling~ Just " +
                "keep on smiling~ Just keep on smiling~ Just keep on smiling~ Just keep on smiling~ Just keep on smiling~ ");
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String singlePost(@PathVariable int id){
        return "This is the post with id " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String postCreationLander(){
        return "This is the post creation page~";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String postCreationPoster(){
        return "This is what you see when you post something... for now!";
    }
}
