package com.example.spring.event_publish.event;

import com.example.spring.event_publish.domain.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeliveryStartedEventHandler {
    private final OrderService orderService;

    @EventListener(DeliveryStartedEvent.class)
    public void handle(DeliveryStartedEvent event) {
        orderService.delivery(event.getOrderNo());
    }

}
