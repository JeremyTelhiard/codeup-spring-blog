package com.codeup.codeupspringblogexercises.controllers;


import com.codeup.codeupspringblogexercises.models.Post;
import com.codeup.codeupspringblogexercises.models.User;
import com.codeup.codeupspringblogexercises.repositories.PostRepository;
import com.codeup.codeupspringblogexercises.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {


    //Dependency Injection
    private PostRepository postRepo;
    private UserRepository userRepo;

    public PostController(PostRepository postRepo, UserRepository userRepo){
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }

    @GetMapping("/posts")
    public String getPosts(Model model){
        List<Post> posts = new ArrayList<>();
        posts.addAll(this.postRepo.findAll());
        model.addAttribute("posts", posts);
        return "posts/index";
    }


    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable long id, Model model){
        Post post = this.postRepo.getById(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/delete")
    public String deletePosts(@RequestParam(name="deleteId") String id){
        this.postRepo.deleteById(Integer.parseInt(id));
        return "redirect:/posts";
    }

    @GetMapping("/posts/create")
    public String createPost(){
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@RequestParam(name="title") String title,
                           @RequestParam(name="body") String body){
        User author = userRepo.getOne(1L);
        Post post = new Post(title, body);
        post.setUser(author);
        this.postRepo.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/edit")
    public String editPost(@RequestParam(name="editId")int id, Model model){
        Post post = this.postRepo.getById(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/posts/edit")
    public String editPost(@RequestParam(name="id")int id,
                           @RequestParam(name="title") String title,
                           @RequestParam(name="body") String body){
        Post post = this.postRepo.getById(id);
        post.setTitle(title);
        post.setBody(body);
        this.postRepo.save(post);
        return "redirect:/posts";
    }




//
//    @GetMapping("/posts")
//    public String postsIndex(Model model){
//        List<Post> posts = new ArrayList<>();
//        Post post = new Post("My awesome lifehacks", "Just keep on smiling~ Just keep on smiling~ Just " +
//                "keep on smiling~ Just keep on smiling~ Just keep on smiling~ Just keep on smiling~ Just keep on smiling~ ");
//        posts.add(post);
//        post = new Post("I'm a sad doggo",
//                "WoofbarkbarkwoofwhineWoofbarkbarkwoofwhineWoofbarkbarkwoofwhineWoofbarkbarkwoofwhine");
//        posts.add(post);
//        model.addAttribute("posts", posts);
//        return "posts/index";
//    }
//
//
//    @GetMapping("/post")
//    public String singlePosting(Model model){
//        Post post = new Post("My awesome lifehacks", "Just keep on smiling~ Just keep on smiling~ Just " +
//                "keep on smiling~ Just keep on smiling~ Just keep on smiling~ Just keep on smiling~ Just keep on smiling~ ");
//        model.addAttribute("post", post);
//        return "posts/show";
//    }
//
//    @GetMapping("/posts/{id}")
//    @ResponseBody
//    public String singlePost(@PathVariable int id){
//        return "This is the post with id " + id;
//    }
//
//    @GetMapping("/posts/create")
//    @ResponseBody
//    public String postCreationLander(){
//        return "This is the post creation page~";
//    }
//
//    @PostMapping("/posts/create")
//    @ResponseBody
//    public String postCreationPoster(){
//        return "This is what you see when you post something... for now!";
//    }
}
