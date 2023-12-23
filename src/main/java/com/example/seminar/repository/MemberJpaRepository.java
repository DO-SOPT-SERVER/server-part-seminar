package com.example.seminar.repository;

import com.example.seminar.domain.Member;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {

    default Member findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(
                () -> new EntityNotFoundException("존재하지 않는 회원입니다."));
    }

    Member findByIdAndDeleted(Long id, boolean isDeleted);

    void deleteByDeletedAtBefore(LocalDateTime now);

    @Modifying
    @Query("delete from Member m where m.deletedAt < now()")
    void deleteExpiredMember();
}
