package com.example.spring.event_publish.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DeliveryService {
    private final DeliveryRepository repository;

    public void updateDeliveryStatus(Long deliveryId, DeliveryState state) {
        Delivery delivery = repository.findById(deliveryId)
                .orElseThrow(() -> new IllegalArgumentException("배송 정보가 존재하지 않습니다."));
        delivery.update(state);;
    }

}
