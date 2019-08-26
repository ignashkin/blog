package com.egor.blog.repo;

import com.egor.blog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByActivationCode(String code);

    User findByEmail(String email);

    User findByUsernameOrEmail(String username, String email);
}