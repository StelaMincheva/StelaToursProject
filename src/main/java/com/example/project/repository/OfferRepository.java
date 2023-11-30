package com.example.project.repository;

import com.example.project.model.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
    List<Offer> findByDestination_Country(String country);

    Optional<Offer> findById(Long id);

}
