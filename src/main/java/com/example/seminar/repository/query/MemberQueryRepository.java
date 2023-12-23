package com.example.seminar.repository.query;

import com.example.seminar.domain.Member;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface MemberQueryRepository extends Repository<Member,Long>{

    @Query(nativeQuery = true, value = "SELECT * FROM member WHERE id=?1")
    Member getMemberById(Long id);

}
