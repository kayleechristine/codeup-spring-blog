package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    // Get All Posts
    @GetMapping("/posts")
    public String getAllPosts(Model model){
        model.addAttribute("allPosts", postDao.findAll());
        return "posts/index";
    }

    // Get Post by ID
    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable long id, Model model){
        model.addAttribute("post", postDao.findById(id).get());
        return "posts/show";
    }

    // Draft a Post
    @GetMapping("/posts/create")
    public String createPost(){
        return "posts/create";
    }

    // Create a Post
    @PostMapping("/posts/create")
    public String submitPost(@RequestParam String title, @RequestParam String body) {
        Post newPost = new Post(title, body);
        postDao.save(newPost);
        return "redirect:/posts";
    }

}
