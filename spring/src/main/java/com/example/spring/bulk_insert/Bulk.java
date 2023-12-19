package com.example.spring.bulk_insert;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Bulk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bulk", cascade = CascadeType.ALL)
    private List<ChildBulk> childBulks = new ArrayList<>();

    @Builder
    private Bulk(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addChild(ChildBulk childBulk){
        childBulks.add(childBulk);
        childBulk.setBulk(this);
    }

}
