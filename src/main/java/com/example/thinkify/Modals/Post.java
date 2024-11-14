package com.example.thinkify.Modals;
import java.time.LocalDateTime;
import java.util.UUID;

public class Post {
    private String postId;
    private String userId;
    private String content;
    private LocalDateTime timestamp;
    private int likes;
    private int dislikes;
    public Post(String userId, String content) {
        this.postId = UUID.randomUUID().toString(); // Generate a unique ID
        this.userId = userId;
        this.content = content;
        this.timestamp = LocalDateTime.now();
        this.likes = 0;
        this.dislikes = 0;
    }

    // Getters and setters
    public String getPostId() {
        return postId;
    }

    public String getUserId() {
        return userId;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getLikes() {
        return likes;
    }

    public void incrementLikes() {
        likes++;
    }

    public void decrementLikes() {
        if (likes > 0) likes--;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void incrementDislikes() {
        dislikes++;
    }

    public void decrementDislikes() {
        if (dislikes > 0) dislikes--;
    }
}
