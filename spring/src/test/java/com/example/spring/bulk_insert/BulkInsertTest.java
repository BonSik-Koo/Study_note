package com.example.spring.bulk_insert;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class BulkInsertTest {
    @Autowired
    BulkRepository repository;

    @Autowired
    BulkJdbcRepository jdbcRepository;

    @Test
    @Rollback(value = false)
    void jpa_saveAll() {
        final List<Bulk> bulks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bulks.add(Bulk.builder()
                    .name("test" + i)
                    .build());
        }

        repository.saveAll(bulks);
    }

    @Test
    void jpa_oneToOne_saveALL() {
        final List<Bulk> bulks = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Bulk parent = Bulk.builder()
                    .name("parent" + i)
                    .build();
            for (int j = 0; j < 3; j++) {
                ChildBulk child = ChildBulk.builder()
                        .name("child" + j)
                        .build();
                parent.addChild(child);
            }

            bulks.add(parent);
        }

        repository.saveAll(bulks);
    }

    @Test
    void jdbc_saveAll() {
        final List<Bulk> bulks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bulks.add(Bulk.builder()
                    .name("test" + i)
                    .build());
        }
        jdbcRepository.saveALL(bulks);
    }

}
