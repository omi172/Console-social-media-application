package com.example.thinkify.Modals;

import java.time.Duration;
import java.time.LocalDateTime;

public class TimeUtils {

    public static String getRelativeTime(LocalDateTime postTime) {
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(postTime, now);

        long seconds = duration.getSeconds();
        long minutes = duration.toMinutes();
        long hours = duration.toHours();
        long days = duration.toDays();

        if (seconds < 60) {
            return seconds + "s ago";
        } else if (minutes < 60) {
            return minutes + "m ago";
        } else if (hours < 24) {
            return hours + "h ago";
        } else {
            return days + "d ago";
        }
    }
}

