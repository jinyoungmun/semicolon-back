package com.webmister.semicolon.repository;

import com.webmister.semicolon.domain.UserInfo;
import org.apache.catalina.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    boolean existsByUserEmail(String Email);
    boolean existsByUserNickName(String name);

    UserInfo findByUserEmailAndPassword(String email, String password);
}