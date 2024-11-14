package com.example.thinkify.Services;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.thinkify.Modals.User;

@Service
public class UserService {
    private final Map<String, User> users = new HashMap<>();

    public String registerUser(String userId, String username) {
        if (users.containsKey(userId)) {
            return "User ID already exists.";
        }
        User newUser = new User(userId, username);
        users.put(userId, newUser);
        return "User " + username + " registered successfully!";
    }

    public User getUser(String userId) {
        return users.get(userId);
    }

    public Collection<User> getAllUsers() {
        return users.values();
    }
   
    public String followUser(String userId1, String userId2) {
        User user1 = users.get(userId1);
        User user2 = users.get(userId2);
        
        if (user1 == null || user2 == null) {
            return "One or both users not found.";
        }
        
        if (user1.getFollowing().contains(user2)) {
            return user1.getUsername() + " is already following " + user2.getUsername();
        }
        
        user1.follow(user2);
        user2.addFollower(user1);
        
        return user1.getUsername() + " is now following " + user2.getUsername();
    }

    public String unfollowUser(String userId1, String userId2) {
        User user1 = users.get(userId1);
        User user2 = users.get(userId2);
        
        if (user1 == null || user2 == null) {
            return "One or both users not found.";
        }
        
        if (!user1.getFollowing().contains(user2)) {
            return user1.getUsername() + " is not following " + user2.getUsername();
        }
        
        user1.unfollow(user2);
        user2.removeFollower(user1);
        
        return user1.getUsername() + " has unfollowed " + user2.getUsername();
    }

}
