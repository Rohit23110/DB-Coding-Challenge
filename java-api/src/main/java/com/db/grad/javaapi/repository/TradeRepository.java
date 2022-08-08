package com.db.grad.javaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.db.grad.javaapi.model.Trade;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Integer>{

    Trade findTopByOrderByIdDesc();

    @Query(value = "SELECT * FROM TRADE t LEFT JOIN BOOK b ON t.bookid = b.id WHERE b.id = ?1", nativeQuery = true)
    List<Trade> findTradesByBookid(Integer bookid);

    List<Trade> findBySecurityid(Integer bookid);
}