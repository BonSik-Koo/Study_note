package com.example.spring.event_publish.event;

public class DeliveryStartedEvent extends Event{
    public Long orderNo;

    public DeliveryStartedEvent(Long id) {
        super();
        this.orderNo = id;
    }

    public Long getOrderNo() {
        return orderNo;
    }

}
