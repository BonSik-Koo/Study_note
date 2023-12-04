package com.example.spring.event_publish.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

// 이벤트 디스패처
@Service
public class EventPublisher {
    private static ApplicationEventPublisher publisher;

    public static void setPublisher(ApplicationEventPublisher publisher){
        EventPublisher.publisher = publisher;
    }

    public static void raise(Object event) {
        if (publisher != null) {
            publisher.publishEvent(event);
        }
    }

}
