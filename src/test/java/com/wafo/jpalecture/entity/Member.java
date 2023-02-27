package com.wafo.jpalecture.entity;

import jakarta.persistence.*;

@Entity
public class Member extends BaseEntity{

    @Id
    @GeneratedValue
    private Long memberId;

    private String username;

    @ManyToOne
    @JoinColumn(name = "team_id", insertable = false, updatable = false)
    private Team team;

    protected Member() {}

    public Member(String username) {
        this.username = username;
    }
}
