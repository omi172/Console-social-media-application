package com.example.thinkify.Modals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class User {
    private String userId;
    private String username;
    private Set<User> followers; // Users who follow this user
    private Set<User> following; // Users this user is following
    private List<Post> posts; 
   
    public User(String userId, String username) {
        this.userId = userId;
        this.username = username;
        this.followers = new HashSet<>();
        this.following = new HashSet<>();
        this.posts = new ArrayList<>();
    }

    // Getters and setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<User> getFollowers() {
        return followers;
    }

    public Set<User> getFollowing() {
        return following;
    }

    public void addFollower(User user) {
        followers.add(user);
    }

    public void removeFollower(User user) {
        followers.remove(user);
    }

    public void follow(User user) {
        following.add(user);
    }

    public void unfollow(User user) {
        following.remove(user);
    }
}
