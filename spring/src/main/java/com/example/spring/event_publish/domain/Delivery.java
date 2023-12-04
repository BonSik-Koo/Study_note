package com.example.spring.event_publish.domain;

import com.example.spring.event_publish.event.DeliveryStartedEvent;
import com.example.spring.event_publish.event.EventPublisher;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated
    private DeliveryState state;

    public Delivery(DeliveryState state) {
        this.state = state;
    }

    public void startDelivery() {
        this.state = DeliveryState.DELIVERY_ING;
        // 이벤트 발행
        EventPublisher.raise(new DeliveryStartedEvent(id));
    }

}
