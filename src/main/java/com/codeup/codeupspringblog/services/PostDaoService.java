package com.codeup.codeupspringblog.services;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class PostDaoService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostDaoService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    // CREATE
    public void savePost(Post post) {
        post.setUser(userRepository.findById(1L).get().getUser());
        postRepository.save(post);
    }


    // READ

    // UPDATE

    // DELETE


}
