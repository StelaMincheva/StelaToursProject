package com.example.project.repository;

import com.example.project.model.entity.SeasonalOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonalOfferRepository extends JpaRepository<SeasonalOffer, Long> {
}
