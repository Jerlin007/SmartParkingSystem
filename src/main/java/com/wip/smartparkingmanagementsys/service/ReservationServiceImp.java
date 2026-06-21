package com.wip.smartparkingmanagementsys.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wip.smartparkingmanagementsys.dto.ReservationDto;
import com.wip.smartparkingmanagementsys.entity.Parking_Slot;
import com.wip.smartparkingmanagementsys.entity.Reservation;
import com.wip.smartparkingmanagementsys.entity.Vehicle;
import com.wip.smartparkingmanagementsys.repository.Parking_SlotRepository;
import com.wip.smartparkingmanagementsys.repository.ReservationRepository;
import com.wip.smartparkingmanagementsys.repository.VehicleRepository;
import com.wip.smartparkingmanagementsys.util.ReservationConverter;

@Service
public class ReservationServiceImp implements ReservationService {
	
	@Autowired
	private VehicleRepository vehiclerepository;
	
	@Autowired
	private ReservationRepository reservationrepository;
	
	@Autowired
	private Parking_SlotRepository slotrepository;

	@Override
	public ReservationDto createReservation(ReservationDto reservationdto) {
        Reservation reservation = ReservationConverter.toEntity(reservationdto);
        Vehicle vehicle = vehiclerepository.findById(reservationdto.getVehicle_id())
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
        Parking_Slot slot = slotrepository.findById(reservationdto.getSlot_id())
                .orElseThrow(() -> new RuntimeException("Slot not found"));
        reservation.setVehicle(vehicle);
        reservation.setPs(slot);
        slot.setStatus("RESERVED");
        slotrepository.save(slot);
        Reservation saved = reservationrepository.save(reservation);
        return ReservationConverter.toDto(saved);
	}

	@Override
	public ReservationDto cancelReservation(Long reservation_id) {
        Reservation reservation = reservationrepository.findById(reservation_id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
        reservation.setStatus("CANCELLED");
        Parking_Slot slot = reservation.getPs();
        slot.setStatus("AVAILABLE");
        slotrepository.save(slot);
        Reservation saved = reservationrepository.save(reservation);
        return ReservationConverter.toDto(saved);
	}

	@Override
	public ReservationDto getById(Long reservation_id) {
        Reservation reservation = reservationrepository.findById(reservation_id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
        return ReservationConverter.toDto(reservation);
	}

	@Override
	public List<ReservationDto> getByVehicle(Long vehicle_id) {
        return reservationrepository.findByVehicleVehicleId(vehicle_id)
                .stream()
                .map(ReservationConverter::toDto)
                .collect(Collectors.toList());
	}

}
