package com.example.project.model.dto;

import java.util.List;

public class AllSeasonalDestinationsDto {

    private List<SeasonalDestinationDto> seasonalDestinations;

    public AllSeasonalDestinationsDto(List<SeasonalDestinationDto> seasonalDestinations) {
        this.seasonalDestinations = seasonalDestinations;
    }

    public List<SeasonalDestinationDto> getSeasonalDestinations() {
        return seasonalDestinations;
    }

    public void setSeasonalDestinations(List<SeasonalDestinationDto> seasonalDestinations) {
        this.seasonalDestinations = seasonalDestinations;
    }
}
