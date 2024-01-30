package com.example.spring.PK.sequence;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class SequenceMemberTest {
    @Autowired
    SequenceMemberRepository sequenceRepository;

    @Autowired
    EntityManager em;

    @Test
    void sequence_pk() {
        SequenceMember sequence = new SequenceMember("test");
        em.persist(sequence);
        em.flush();
    }

    @Test
    void sequence_pk_batch() {
        for(int i=0; i<2; i++){
            SequenceMember member = new SequenceMember("test" + i);
            em.persist(member);
        }
        System.out.println("=======");
        em.flush();
    }

}