package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.services.EmailService;
import com.codeup.codeupspringblog.services.PostDaoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    // Service Injection
    private final PostDaoService postService;
    private final EmailService emailService;

    public PostController(PostDaoService postService, EmailService emailService) {
        this.postService = postService;
        this.emailService = emailService;
    }

    // Browse All Posts
    @GetMapping("/posts")
    public String browsePosts(Model model){
        model.addAttribute("posts", postService.getAllPosts());
        return "posts/index";
    }

    // View a Post
    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable long id, Model model){
        model.addAttribute("post", postService.getPostById(id));
        return "posts/show";
    }

    // Draft a Post
    @GetMapping("/posts/create")
    public String draftPost(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    // Create a Post
    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        postService.savePost(post);
        emailService.sendTextEmail(post);
        return "redirect:/posts/" + post.getId();
    }

    // Edit a Post
    @GetMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, Model model){
        model.addAttribute("post", postService.getPostById(id));
        return "posts/edit";
    }

    // Submit an Edit
    @PostMapping("/posts/edit")
    public String updatePost(@ModelAttribute Post post) {
        postService.savePost(post);
        return "redirect:/posts/" + post.getId();
    }

    // Delete a Post
    @GetMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id) {
        postService.deletePostById(id);
        return "redirect:/posts";
    }

}
