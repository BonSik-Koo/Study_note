package com.example.spring.event_publish;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.spring.event_publish.domain.Delivery;
import com.example.spring.event_publish.domain.DeliveryRepository;
import com.example.spring.event_publish.domain.DeliveryService;
import com.example.spring.event_publish.domain.DeliveryState;
import com.example.spring.event_publish.domain.Order;
import com.example.spring.event_publish.domain.OrderRepository;
import com.example.spring.event_publish.domain.OrderState;
import jakarta.persistence.EntityManager;
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
    public void testDown(){
        orderRepository.deleteAll();
        deliveryRepository.deleteAll();
    }

    @DisplayName("배송을 시작하면 이벤트를 통해 주문 상태를 배송중 상태로 변경한다.")
    @Test
    void deliveyEventPublish() {
        //given
        Order createOrder = new Order(OrderState.ORDER);
        Delivery createDelivery = new Delivery(DeliveryState.PICK_UP);
        orderRepository.save(createOrder);
        deliveryRepository.save(createDelivery);

        //when
        deliveryService.delivery(createDelivery.getId());

        //then
        Order findOrder = orderRepository.findById(createOrder.getId()).get();
        assertThat(findOrder.getState()).isEqualByComparingTo(OrderState.DELIVERY);
    }

}