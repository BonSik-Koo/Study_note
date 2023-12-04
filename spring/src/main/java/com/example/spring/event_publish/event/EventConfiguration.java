package com.example.spring.event_publish.event;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventConfiguration {
    @Autowired
    ApplicationEventPublisher publisher;

    @Bean
    public InitializingBean eventsInit(){
        return () -> EventPublisher.setPublisher(publisher);
    }
}
