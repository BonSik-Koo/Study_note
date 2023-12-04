package com.example.spring.event_publish.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public void delivery(Long orderNo){
        Order order = orderRepository.findById(orderNo)
                .orElseThrow(() -> new IllegalArgumentException("주문 정보가 존재하지 않습니다."));
        order.delivery();
    }

}
