package com.wip.smartparkingmanagementsys.util;

import com.wip.smartparkingmanagementsys.dto.ReservationDto;
import com.wip.smartparkingmanagementsys.entity.Reservation;

public class ReservationConverter {
	
    public static ReservationDto toDto(Reservation reservation) {
        ReservationDto dto = new ReservationDto();
        dto.setReservation_id(reservation.getReservation_id());
        dto.setReservation_time(reservation.getReservation_time());
        dto.setStart_time(reservation.getStart_time());
        dto.setEnd_time(reservation.getEnd_time());
        dto.setStatus(reservation.getStatus());
        dto.setVehicle_id(reservation.getVehicle().getVehicle_id());
        dto.setSlot_id(reservation.getPs().getSlot_id());
        return dto;
    }

    public static Reservation toEntity(ReservationDto dto) {
        Reservation reservation = new Reservation();
        reservation.setReservation_time(dto.getReservation_time());
        reservation.setStart_time(dto.getStart_time());
        reservation.setEnd_time(dto.getEnd_time());
        reservation.setStatus(dto.getStatus());
        // vehicle and slot set in service
        return reservation;
    }
	
	
	
}
