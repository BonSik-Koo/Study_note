package com.example.spring.java_concurrent.atomicity;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/race-condition")
public class RaceConditionController {
    public static Integer amount = 0;

    @PostMapping("/increase1")
    public ResponseEntity<Void> increaseCount1() {
        amount++;
        return ResponseEntity.ok().build();
    }

    @PostMapping("/increase2")
    public ResponseEntity<Void> increaseCount2() throws InterruptedException {
        amount++;
        if(amount < 10) {
            Thread.sleep(2);
            System.out.println("10개 미만! amount = " + amount);
        }
        return ResponseEntity.ok().build();
    }

}
