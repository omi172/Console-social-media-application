package com.example.thinkify.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.thinkify.Services.PostService;
@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/upload")
    public String uploadPost(@RequestParam String userId, @RequestParam String content) {
        return postService.uploadPost(userId, content);
    }

    @PostMapping("/interact")
    public String interactWithPost(
            @RequestParam String interactionType,
            @RequestParam String userId,
            @RequestParam String postId) {
        return postService.interactWithPost(interactionType, userId, postId);
    }
}
