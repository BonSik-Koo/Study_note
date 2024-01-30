package com.example.spring.PK.table;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.TableGenerator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TableMember {

    @Id
    @TableGenerator(
            name = "MEMBER_SEQ_GENERATOR",
            table = "MEMBER_SEQ_TABLE",
            pkColumnName = "MEMBER_SEQ",
            initialValue = 1,
            allocationSize = 50
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "MEMBER_SEQ_GENERATOR")
    private Long id;
    private String name;

    public TableMember(String name) {
        this.name = name;
    }

}
