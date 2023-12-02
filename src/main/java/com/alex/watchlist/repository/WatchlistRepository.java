package com.alex.watchlist.repository;

import com.alex.watchlist.model.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories(basePackages = "com.springboot.reserving.member")
@Repository
public interface WatchlistRepository extends JpaRepository<Watchlist, Integer> {
    List<Watchlist> findByUserId(Integer id);
    Optional<Watchlist> deleteByProductId(Integer id);
}
