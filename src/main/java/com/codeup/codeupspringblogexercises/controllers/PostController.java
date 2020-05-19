package com.codeup.codeupspringblogexercises.controllers;


import com.codeup.codeupspringblogexercises.models.EmailService;
import com.codeup.codeupspringblogexercises.models.Post;
import com.codeup.codeupspringblogexercises.models.User;
import com.codeup.codeupspringblogexercises.repositories.PostRepository;
import com.codeup.codeupspringblogexercises.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private EmailService emailService;

    public PostController(PostRepository postRepo, UserRepository userRepo, EmailService emailService){
        this.postRepo = postRepo;
        this.userRepo = userRepo;
        this.emailService = emailService;
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

//    @GetMapping("/posts/create")
//    public String createPost(Model model){
//        model.addAttribute("post", new Post());
//        return "posts/create";
//    }

//    @PostMapping("/posts/create")
//    public String createPost(@RequestParam(name="title") String title,
//                           @RequestParam(name="body") String body){
//        User author = userRepo.getOne(1L);
//        Post post = new Post(title, body);
//        post.setUser(author);
//        this.postRepo.save(post);
//        return "redirect:/posts";
//    }

//    @PostMapping("/posts/create")
//    public String createPost(Post post){
//        User author = userRepo.getOne(1L);
//        post.setUser(author);
//        this.postRepo.save(post);
//        this.emailService.prepareAndSend(post, "You just posted this ad!", "Post title: " + post.getTitle()+ "" +
//                "Post body: " + post.getBody());
//        return "redirect:/posts";
//    }

    @GetMapping("/posts/makeapost")
    public String makePost(@RequestParam(name="editId", required=false)Integer id, Model model){
        if (id == null){
            model.addAttribute("post", new Post());
        } else {
            Post post = this.postRepo.getById(id);
            model.addAttribute("post", post);
        }
        return "posts/makeapost";
    }

    @PostMapping("/posts/makeapost")
    public String makePost(Post post){
        if(post.getUser() == null){
            User author = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            post.setUser(author);
        }
        this.postRepo.save(post);
        this.emailService.prepareAndSend(post, "You just posted this ad!", "Post title: " + post.getTitle()+
                "\n\nPost body: " + post.getBody() + "\n\nThank you very much!");
        return "redirect:/posts";
//        return "redirect:/posts/" + post.getId();
    }



    //mapping for searching through posts 
//    @GetMapping("posts/search") 
//    public String searchForPosts(@RequestParam(name = "searchTerm") String searchTerm, Model model){ 
//        List<Post> filteredPosts = postRepository.findByBodyContaining(searchTerm);
//        filteredPosts.addAll(postRepository.findByTitleContaining(searchTerm)); 
//        model.addAttribute("posts", filteredPosts); 
//        return "posts/index"; 
//    }








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
