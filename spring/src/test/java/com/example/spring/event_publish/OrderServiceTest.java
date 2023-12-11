package com.example.spring.event_publish;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.spring.event_publish.domain.Delivery;
import com.example.spring.event_publish.domain.DeliveryRepository;
import com.example.spring.event_publish.domain.DeliveryService;
import com.example.spring.event_publish.domain.DeliveryState;
import com.example.spring.event_publish.domain.Order;
import com.example.spring.event_publish.domain.OrderRepository;
import com.example.spring.event_publish.domain.OrderState;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderServiceTest {
    @Autowired DeliveryService deliveryService;

    @Autowired DeliveryRepository deliveryRepository;

    @Autowired OrderRepository orderRepository;

    @AfterEach
    public void tearDown(){
        orderRepository.deleteAllInBatch();
        deliveryRepository.deleteAllInBatch();
    }

    @DisplayName("배송이 완료되면 주문은 배송 완료 상태가 된다.")
    @Test
    void deliveryCompleted() {
        //given
        Order createOrder = new Order(null, OrderState.DELIVERY_ING);
        orderRepository.save(createOrder);
        Delivery createDelivery = new Delivery(null, createOrder.getId(), DeliveryState.DELIVERY_ING);
        deliveryRepository.save(createDelivery);

        //when
        deliveryService.updateDeliveryStatus(createDelivery.getId(), DeliveryState.DELIVERY_COMPLETED);

        //then
        Order findOrder = orderRepository.findById(createOrder.getId()).get();
        assertThat(findOrder.getState()).isEqualByComparingTo(OrderState.DELIVERY_COMPLETED);
    }

}