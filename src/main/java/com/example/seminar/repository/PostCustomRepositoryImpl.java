package com.example.seminar.repository;

import com.example.seminar.domain.Member;
import com.example.seminar.domain.Post;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.seminar.domain.QPost.post;

@Repository
@RequiredArgsConstructor
public class PostCustomRepositoryImpl implements PostCustomRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public Post getPostById(Long id) {
        return queryFactory.selectFrom(post)
                .where(
                        post.id.eq(id)
                )
                .fetchOne();
    }

    @Override
    public List<Post> getPostsByMember(Member member) {
        return queryFactory.selectFrom(post)
                .where(
                        post.member.eq(member)
                ).fetch();
    }
}
