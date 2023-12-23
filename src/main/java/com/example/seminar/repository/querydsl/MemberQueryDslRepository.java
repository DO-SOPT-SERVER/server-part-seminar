package com.example.seminar.repository.querydsl;


import com.example.seminar.domain.Member;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.util.StringUtils;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import static com.example.seminar.domain.QMember.member;

@Repository
@RequiredArgsConstructor
public class MemberQueryDslRepository {
    private final JPAQueryFactory queryFactory;

    public void deleteExpiredMember() {
        queryFactory.delete(member)
                .where(member.deletedAt.before(LocalDateTime.now()))
                .execute();
    }

    public Member getMemberById(Long id) {
        return queryFactory.selectFrom(member)
                .where(member.id.eq(id)).fetchOne();
    }

    public void updateMemberGeneration(int generation, Long id) {
        queryFactory.update(member)
                .where(member.id.eq(id))
                .set(member.sopt.generation, generation)
                .execute();
    }

    public void deleteMemberById(Long id) {
        queryFactory.delete(member)
                .where(member.id.eq(id))
                .execute();
    }

    public List<Member> findMemberBySearch(String name, String nickname, Integer generation) {
        return queryFactory.selectFrom(member)
                .where(eqName(name), eqNickname(nickname), eqGeneration(generation))
                .fetch();
    }

    private BooleanExpression eqName(String name) {
        if (StringUtils.isNullOrEmpty(name)) {
            return null;
        }
        return member.name.containsIgnoreCase(name);
    }

    private BooleanExpression eqNickname(String nickname) {
        if (StringUtils.isNullOrEmpty(nickname)) {
            return null;
        }
        return member.nickname.containsIgnoreCase(nickname);
    }

    private BooleanExpression eqGeneration(Integer generation) {
        if (generation == null ) {
            return null;
        }
        return member.sopt.generation.eq(generation);
    }
}
