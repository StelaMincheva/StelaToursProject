package com.example.project.service;

import com.example.project.model.dto.AllSeasonalDestinationsDto;
import com.example.project.model.dto.SeasonalDestinationAddDto;

public interface SeasonalDestinationService {

    void addSeasonalDestination(SeasonalDestinationAddDto seasonalDestinationAddDto);

    AllSeasonalDestinationsDto getAllSeasonalDestinations();
    void deleteSeasonalDestination(Long id);
}
