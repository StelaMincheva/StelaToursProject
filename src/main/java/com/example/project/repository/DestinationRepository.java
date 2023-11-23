package com.example.project.repository;

import com.example.project.model.entity.Country;
import com.example.project.model.entity.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {

    Optional<Destination> findByCountry(Country country);
}
