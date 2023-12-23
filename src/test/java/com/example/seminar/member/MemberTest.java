package com.example.seminar.member;


import com.example.seminar.domain.Member;
import com.example.seminar.domain.Part;
import com.example.seminar.domain.SOPT;
import com.example.seminar.repository.MemberJpaRepository;
import com.example.seminar.repository.query.MemberQueryRepository;
import com.example.seminar.repository.querydsl.MemberQueryDslRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberTest {

    @Autowired
    MemberQueryRepository memberQueryRepository;

    @Autowired
    MemberJpaRepository memberJpaRepository;

    @Autowired
    MemberQueryDslRepository memberQueryDslRepository;

    @Nested
    @DisplayName("member jpa repository test")
    class MemberJpaRepositoryTest {

        @Test
        @DisplayName("member query test")
        void test_MemberJpaRepository_조회() {
            Member member = memberJpaRepository.save(
                    Member.builder()
                            .name("유난")
                            .age(20)
                            .sopt(new SOPT(33, Part.SERVER))
                            .nickname("유난이")
                            .build());
            Member findMember = memberJpaRepository.findByIdOrThrow(member.getId());
            Assertions.assertThat(findMember.getName()).isEqualTo("유난");
        }

    }

    @Nested
    @DisplayName("member query test")
    class MemberQueryRepositoryTest {

        @Test
        @DisplayName("member query test")
        void test_MemberQueryRepository_조회() {
            Member member = memberJpaRepository.save(
                    Member.builder()
                            .name("유난")
                            .age(20)
                            .sopt(new SOPT(33, Part.SERVER))
                            .nickname("유난이")
                            .build());
            Member findMember = memberQueryRepository.getMemberById(member.getId());
            Assertions.assertThat(findMember.getName()).isEqualTo("유난");
        }

    }

    @Nested
    @DisplayName("member querydsl test")
    class MemberQueryDslRepositoryTest {
        @Test
        @DisplayName("member 조회 test")
        void test_MemberQueryDslRepository_조회() {
            Member member = memberJpaRepository.save(
                    Member.builder()
                            .name("유난")
                            .age(20)
                            .sopt(new SOPT(33, Part.SERVER))
                            .nickname("유난이")
                            .build());
            Member findMember = memberQueryDslRepository.getMemberById(member.getId());
            Assertions.assertThat(findMember.getName()).isEqualTo("유난");
        }
    }
}
