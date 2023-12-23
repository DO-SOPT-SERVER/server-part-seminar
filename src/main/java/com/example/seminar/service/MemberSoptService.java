package com.example.seminar.service;


import com.example.seminar.domain.Member;
import com.example.seminar.domain.SOPT;
import com.example.seminar.dto.request.member.MemberProfileUpdateRequest;
import com.example.seminar.repository.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberSoptService {

    private final MemberJpaRepository memberJpaRepository;

    @Transactional
    public void updateSOPT(Long memberId, MemberProfileUpdateRequest request) {
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        member.updateSOPT(new SOPT(request.getGeneration(), request.getPart()));
    }
}
