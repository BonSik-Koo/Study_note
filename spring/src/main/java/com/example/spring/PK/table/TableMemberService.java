package com.example.spring.PK.table;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TableMemberService {
    private final TableMemberRepository memberRepository;

    public void saveAll(List<TableMember> members) {
        memberRepository.saveAll(members);
    }
}
