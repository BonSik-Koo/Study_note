package com.example.spring.event_publish.domain;

import com.example.spring.event_publish.event.DeliveryCompletedEvent;
import com.example.spring.event_publish.event.EventPublisher;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;

    @Enumerated
    private DeliveryState state;

    public void update(DeliveryState state) {
        this.state = state;

        // 이벤트 발행
        if (state.equals(DeliveryState.DELIVERY_COMPLETED)) {
            EventPublisher.raise(new DeliveryCompletedEvent(orderId));
        }
    }

}
