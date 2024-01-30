package com.example.spring.PK.table;

import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
class TableMemberTest {
    @Autowired
    TableMemberService memberService;

    @Autowired
    EntityManager em;

    @Test
    void table_pk(){
        for(int i=0; i<5; i++){
            TableMember member = new TableMember("test" + i);
            em.persist(member);
        }
        em.flush();
     }

    @Test
    void table_pk_batch_insert() {
        final List<TableMember> members = new ArrayList<>();
        for(int i=0; i<100; i++){
            members.add(new TableMember("test" + i));
        }

        memberService.saveAll(members);
        em.flush();
    }

}