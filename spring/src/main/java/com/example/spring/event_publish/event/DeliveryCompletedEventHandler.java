package com.example.spring.event_publish.event;

import com.example.spring.event_publish.domain.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
@RequiredArgsConstructor
public class DeliveryCompletedEventHandler {
    private final OrderService orderService;

    @EventListener(DeliveryCompletedEvent.class)
    public void defaultListener(DeliveryCompletedEvent event){
        log.info("default listener = {}", event);
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMPLETION)
    public void afterCompletionListener(DeliveryCompletedEvent event){
        log.info("after completion listener = {}" ,event);
    }

    @Async
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @TransactionalEventListener // default : TransactionPhase.AFTER_COMMIT
    public void afterCommitListener(DeliveryCompletedEvent event) {
        log.info("after commit listener = {}", event);
        orderService.completedDelivery(event.getOrderId());
    }

}
