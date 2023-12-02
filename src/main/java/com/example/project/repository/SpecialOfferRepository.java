package com.example.project.repository;

import com.example.project.model.entity.Offer;
import com.example.project.model.entity.SpecialOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpecialOfferRepository extends JpaRepository<SpecialOffer, Long> {
    List<SpecialOffer> findBySeasonalDestination_Title(String title);

    Optional<SpecialOffer> findById(Long id);
}
