package com.example.project.repository;

import com.example.project.model.entity.SeasonalDestination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonalDestinationRepository extends JpaRepository<SeasonalDestination, Long> {
}
