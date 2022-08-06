package com.db.grad.javaapi.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db.grad.javaapi.model.Security;

@Repository
public interface SecurityRepository extends JpaRepository<Security, Integer>{

    List<Security> findByMaturitydateBetween(Date date1, Date date2);

    Security findTopByOrderByIdDesc();

}