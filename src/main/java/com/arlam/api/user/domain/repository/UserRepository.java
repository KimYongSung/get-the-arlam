package com.arlam.api.user.domain.repository;

import com.arlam.api.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 이메일 정보로 유저 정보 조회
     * @param email
     * @return
     */
    Optional<User> findByEmail(String email);
}
