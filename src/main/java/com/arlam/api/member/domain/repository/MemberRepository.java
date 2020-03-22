package com.arlam.api.member.domain.repository;

import com.arlam.api.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    /**
     * ID 정보로 유저 정보 조회
     * @param memId
     * @return
     */
    Optional<Member> findByMemId(String memId);
}
