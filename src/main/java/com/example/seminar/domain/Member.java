package com.example.seminar.domain;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity{

    private static final Long MEMBER_INFO_RETENTION_PERIOD = 30L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nickname;
    private int age;

    @Embedded
    private SOPT sopt;

    private boolean isDeleted = false;
    private LocalDateTime deletedAt;


    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private final List<Post> posts = new ArrayList<>();

    @Builder
    public Member(String name, String nickname, int age, SOPT sopt) {
        this.name = name;
        this.nickname = nickname;
        this.age = age;
        this.sopt = sopt;
    }


    public void softDelete() {
        this.isDeleted = true;
        this.deletedAt = LocalDateTime.now().plusDays(MEMBER_INFO_RETENTION_PERIOD);
    }

    public void recover() {
        this.isDeleted = false;
        this.deletedAt = null;
    }

    public void updateSOPT(SOPT sopt) {
        this.sopt = sopt;
    }
}
