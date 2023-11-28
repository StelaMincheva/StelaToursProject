package com.example.project.service.impl;

import com.example.project.model.dto.ReservationAddDto;
import com.example.project.model.entity.Reservation;
import com.example.project.repository.ReservationRepository;
import com.example.project.service.ReservationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final ModelMapper modelMapper;

    public ReservationServiceImpl(ReservationRepository repository, ModelMapper modelMapper) {
        this.reservationRepository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addReservation(ReservationAddDto reservationAddDto) {
        Reservation reservation = modelMapper.map(reservationAddDto, Reservation.class);

        reservationRepository.save(reservation);
    }
}
