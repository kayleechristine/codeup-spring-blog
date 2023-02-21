package com.codeup.codeupspringblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    // Get All Posts
    @GetMapping("/posts")
    @ResponseBody
    public String getAllPosts(){
        return "Posting all posts...";
    }

    // Get Post by ID
    @GetMapping("/posts/{id}")
    @ResponseBody
    public String getPost(@PathVariable int id){
        return "Posting #" + id + "...";
    }

    // Draft a Post
    @GetMapping("/posts/create")
    @ResponseBody
    public String draftPost(){
        return "Making a draft...";
    }

    // Create a Post
    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String createPost() {
        return "Creating a new post...";
    }

}
