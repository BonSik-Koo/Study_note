package com.example.spring.event_publish.event;

import lombok.ToString;

@ToString
public class DeliveryCompletedEvent extends Event{
    public Long orderId;

    public DeliveryCompletedEvent(Long orderId) {
        super();
        this.orderId = orderId;
    }

    public Long getOrderId() {
        return orderId;
    }

}
