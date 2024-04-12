package com.booquo.Quotify.app.repo;

import com.booquo.Quotify.app.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepo extends JpaRepository<Quote, Long> {
}
