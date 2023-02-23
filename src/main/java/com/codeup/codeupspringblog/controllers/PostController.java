package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    // Repository Instantiation
    private final PostRepository postDao;
    private final UserRepository userDao;
    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
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
    public String draftPost(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    // Create a Post
    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        Post newPost = new Post(post.getTitle(), post.getBody(), userDao.findById(1L).get().getUser());
        postDao.save(newPost);
        return "redirect:/posts";
    }

    // Edit a Post
    @GetMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, Model model){
        model.addAttribute("post", postDao.findById(id).get());
        return "posts/edit";
    }

    // Submit an Edit
    @PostMapping("/posts/{id}/edit")
    public String updatePost(@PathVariable long id, @ModelAttribute Post post) {
        post.setUser(userDao.findById(1L).get().getUser());
        postDao.save(post);
        return "redirect:/posts/" + post.getId();
    }
}
