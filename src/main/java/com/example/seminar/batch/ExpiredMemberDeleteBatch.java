package com.example.seminar.batch;


import com.example.seminar.repository.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class ExpiredMemberDeleteBatch {

    private final MemberJpaRepository memberJpaRepository;

    @Scheduled(fixedRate = 1000)
    public void deleteExpiredMember() {
        System.out.println("서버 짱");
        memberJpaRepository.deleteExpiredMember();
    }
}
