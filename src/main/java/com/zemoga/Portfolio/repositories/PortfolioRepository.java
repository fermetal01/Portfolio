package com.zemoga.Portfolio.repositories;

import com.zemoga.Portfolio.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface PortfolioRepository extends JpaRepository<Portfolio,Long> {
    List<Portfolio> findByTitle(String name);
}

