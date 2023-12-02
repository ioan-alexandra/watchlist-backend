package com.alex.watchlist.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alex.watchlist.model.HelloMessage;

@Repository
public interface ReportRepository extends JpaRepository<HelloMessage, Long> {
}