package com.example.spring.event_publish.event;

import java.time.LocalDateTime;

public abstract class Event {
    private LocalDateTime timestamp;

    public Event() {
        this.timestamp = LocalDateTime.now();
    }

    public LocalDateTime getTimestamp(){
        return timestamp;
    }

}
