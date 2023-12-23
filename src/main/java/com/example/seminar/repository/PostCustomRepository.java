package com.example.seminar.repository;

import com.example.seminar.domain.Member;
import com.example.seminar.domain.Post;

import java.util.List;

public interface PostCustomRepository {
    Post getPostById(Long id);
    List<Post> getPostsByMember(Member member);

}
