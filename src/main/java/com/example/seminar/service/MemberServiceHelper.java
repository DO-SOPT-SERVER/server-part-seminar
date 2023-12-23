package com.example.seminar.service;

import com.example.seminar.domain.Member;
import com.example.seminar.repository.MemberJpaRepository;


public final class MemberServiceHelper {
    public static Member getMemberById(MemberJpaRepository memberJpaRepository, Long id) {
        return memberJpaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("사용자가 존재하지 않습니다."));
    }
}
