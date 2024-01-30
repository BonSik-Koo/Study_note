package com.example.spring.PK.sequence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SequenceMemberRepository extends JpaRepository<SequenceMember, Long> {
}
