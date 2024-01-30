package com.example.spring.PK.sequence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SequenceMember {
    @Id
    @SequenceGenerator(
            name = "TEST_SEQ_GENERATOR",
            sequenceName = "TEST_SEQ",
            initialValue = 1,
            allocationSize = 50
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEST_SEQ_GENERATOR")
    private Long id;
    private String name;

    public SequenceMember(String name) {
        this.name = name;
    }
}
