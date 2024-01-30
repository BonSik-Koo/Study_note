package com.example.spring.PK.table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableMemberRepository extends JpaRepository<TableMember, Long> {
}
