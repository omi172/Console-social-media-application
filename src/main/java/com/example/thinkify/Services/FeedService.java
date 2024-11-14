package com.example.thinkify.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import com.example.thinkify.Modals.User;
import com.example.thinkify.Modals.Post;

@Service
public class FeedService {

    @Autowired
    private UserService userService;

    public List<Post> getFeed(String userId) {
        User currentUser = userService.getUser(userId);
        
        if (currentUser == null) {
            throw new IllegalArgumentException("User not found");
        }

        // Get posts from followed users
        List<Post> followedPosts = currentUser.getFollowing().stream()
                .flatMap(user -> user.getPosts().stream())
                .collect(Collectors.toList());

        // Get posts from non-followed users
        List<Post> nonFollowedPosts = userService.getAllUsers().stream()
                .filter(user -> !currentUser.getFollowing().contains(user) && !user.getUserId().equals(userId))
                .flatMap(user -> user.getPosts().stream())
                .collect(Collectors.toList());

        // Combine followed and non-followed posts
        List<Post> allPosts = new ArrayList<>();
        allPosts.addAll(followedPosts);
        allPosts.addAll(nonFollowedPosts);

        // Sort posts: first by follow status, then by timestamp
        return allPosts.stream()
                .sorted(Comparator.comparing((Post post) -> !currentUser.getFollowing().contains(userService.getUser(post.getUserId())))
                        .thenComparing(Post::getTimestamp).reversed())
                .collect(Collectors.toList());
    }
}
