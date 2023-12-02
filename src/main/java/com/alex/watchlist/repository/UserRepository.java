package com.alex.watchlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alex.watchlist.model.User;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories(basePackages = "com.springboot.reserving.member")
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String emailUser);

    Boolean existsByUsername(String username);
    Optional<User> findById(Long id);
    Optional<User> deleteById(Long id);
    Boolean existsByEmail(String email);
    Optional<User> findByUsername(String username);
}
