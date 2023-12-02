package com.example.project.repository;

import com.example.project.model.entity.Destination;
import com.example.project.model.entity.SeasonalDestination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeasonalDestinationRepository extends JpaRepository<SeasonalDestination, Long> {

    Optional<SeasonalDestination> findById(Long id);
}
