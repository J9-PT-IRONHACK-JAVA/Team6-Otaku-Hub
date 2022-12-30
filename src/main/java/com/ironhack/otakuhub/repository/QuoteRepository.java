package com.ironhack.otakuhub.repository;

import com.ironhack.otakuhub.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends JpaRepository<Quote,Long> {
}
