package com.example.thinkify.Services;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service; 

import com.example.thinkify.Modals.Post;
import com.example.thinkify.Modals.TimeUtils;
@Service
public class PostService {
    private final Map<String, Post> posts = new HashMap<>(); // In-memory storage for posts

    public String uploadPost(String userId, String content) {
        Post newPost = new Post(userId, content);
        posts.put(newPost.getPostId(), newPost); // Add post to in-memory storage
        return "Upload Successful with post ID: " + newPost.getPostId();
    }
    
    public Post getPostById(String postId) {
        return posts.get(postId);
    }
    
    public String interactWithPost(String interactionType, String userId, String postId) {
        Post post = posts.get(postId);

        if (post == null) {
            return "Post not found.";
        }

        switch (interactionType.toUpperCase()) {
            case "LIKE":
                post.incrementLikes();
                return "Post liked successfully!";
            case "DISLIKE":
                post.incrementDislikes();
                return "Post disliked successfully!";
            case "UNLIKE":
                post.decrementLikes();
                return "Post unliked successfully!";
            case "UNDISLIKE":
                post.decrementDislikes();
                return "Post undisliked successfully!";
            default:
                return "Invalid interaction type. Use LIKE, DISLIKE, UNLIKE, or UNDISLIKE.";
        }
    } 
     // Assuming posts are stored here

    public List<String> getUserFeedWithRelativeTime(String userId) {
        // Assuming user posts are fetched here (modify as needed for your feed logic)
        return posts.values().stream()
                .map(post -> {
                    String relativeTime = TimeUtils.getRelativeTime(post.getTimestamp());
                    return "UserName - " + post.getUserId() + "\n" +
                           "Post - " + post.getContent() + "\n" +
                           "Post time - " + relativeTime + "\n";
                })
                .collect(Collectors.toList());
    }
}
