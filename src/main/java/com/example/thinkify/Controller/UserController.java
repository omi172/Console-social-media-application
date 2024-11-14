package com.example.thinkify.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.thinkify.Modals.Post;
import com.example.thinkify.Services.FeedService;
import com.example.thinkify.Services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestParam String userId, @RequestParam String username) {
        return userService.registerUser(userId, username);
    }

     @PostMapping("/{userId1}/follow/{userId2}")
    public String followUser(@PathVariable String userId1, @PathVariable String userId2) {
        return userService.followUser(userId1, userId2);
    }

    @PostMapping("/{userId1}/unfollow/{userId2}")
    public String unfollowUser(@PathVariable String userId1, @PathVariable String userId2) {
        return userService.unfollowUser(userId1, userId2);
    }

     @Autowired
    private FeedService feedService;
    
     @GetMapping("/{userId}/feed")
    public Collection<Post> getUserFeed(@PathVariable String userId) {
        return feedService.getFeed(userId);
    }
}
