package com.example.spring.bulk_insert;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BulkRepository extends JpaRepository<Bulk, Long> {

}
