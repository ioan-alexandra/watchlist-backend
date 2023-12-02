package com.alex.watchlist.repository;

import com.alex.watchlist.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories(basePackages = "com.springboot.reserving.member")
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findByUrl(String url);
}
