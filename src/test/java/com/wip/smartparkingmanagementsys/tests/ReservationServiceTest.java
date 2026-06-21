package com.wip.smartparkingmanagementsys.tests;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.wip.smartparkingmanagementsys.dto.ReservationDto;
import com.wip.smartparkingmanagementsys.entity.Parking_Slot;
import com.wip.smartparkingmanagementsys.entity.Reservation;
import com.wip.smartparkingmanagementsys.entity.Vehicle;
import com.wip.smartparkingmanagementsys.repository.Parking_SlotRepository;
import com.wip.smartparkingmanagementsys.repository.ReservationRepository;
import com.wip.smartparkingmanagementsys.repository.VehicleRepository;
import com.wip.smartparkingmanagementsys.service.ReservationServiceImp;

@ExtendWith(MockitoExtension.class)
class ReservationServiceTest {

    @Mock private ReservationRepository reservationRepository;
    @Mock private VehicleRepository vehicleRepository;
    @Mock private Parking_SlotRepository slotRepository;
    @InjectMocks private ReservationServiceImp reservationService;

    @Test
    void createReservation_validData_returnsDto() {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicle_id(1L);

        Parking_Slot slot = new Parking_Slot();
        slot.setSlot_id(1L);
        slot.setStatus("AVAILABLE");

        Reservation saved = new Reservation();
        saved.setReservation_id(1L);
        saved.setVehicle(vehicle);
        saved.setPs(slot);
        saved.setStatus("ACTIVE");
        saved.setReservation_time(LocalDateTime.now());
        saved.setStart_time(LocalDateTime.now());
        saved.setEnd_time(LocalDateTime.now().plusHours(2));

        ReservationDto dto = new ReservationDto();
        dto.setVehicle_id(1L);
        dto.setSlot_id(1L);
        dto.setStatus("ACTIVE");
        dto.setReservation_time(LocalDateTime.now());
        dto.setStart_time(LocalDateTime.now());
        dto.setEnd_time(LocalDateTime.now().plusHours(2));

        when(vehicleRepository.findById(1L)).thenReturn(Optional.of(vehicle));
        when(slotRepository.findById(1L)).thenReturn(Optional.of(slot));
        when(reservationRepository.save(any())).thenReturn(saved);

        ReservationDto result = reservationService.createReservation(dto);

        assertNotNull(result);
        assertEquals(1L, result.getReservation_id());
    }

    @Test
    void cancelReservation_setsStatusCancelled() {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicle_id(1L);

        Parking_Slot slot = new Parking_Slot();
        slot.setSlot_id(1L);
        slot.setStatus("RESERVED");

        Reservation reservation = new Reservation();
        reservation.setReservation_id(1L);
        reservation.setStatus("ACTIVE");
        reservation.setVehicle(vehicle);
        reservation.setPs(slot);

        when(reservationRepository.findById(1L)).thenReturn(Optional.of(reservation));
        when(reservationRepository.save(any())).thenReturn(reservation);

        ReservationDto result = reservationService.cancelReservation(1L);

        assertEquals("CANCELLED", result.getStatus());
        assertEquals("AVAILABLE", slot.getStatus());
    }

    @Test
    void cancelReservation_notFound_throwsException() {
        when(reservationRepository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> reservationService.cancelReservation(99L));
    }

    @Test
    void getByVehicle_returnsReservationList() {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicle_id(1L);

        Parking_Slot slot = new Parking_Slot();
        slot.setSlot_id(1L);

        Reservation reservation = new Reservation();
        reservation.setReservation_id(1L);
        reservation.setVehicle(vehicle);
        reservation.setPs(slot);
        reservation.setStatus("ACTIVE");
        reservation.setReservation_time(LocalDateTime.now());
        reservation.setStart_time(LocalDateTime.now());
        reservation.setEnd_time(LocalDateTime.now().plusHours(1));

        when(reservationRepository.findByVehicleVehicleId(1L)).thenReturn(List.of(reservation));

        List<ReservationDto> result = reservationService.getByVehicle(1L);

        assertFalse(result.isEmpty());
        assertEquals(1L, result.get(0).getReservation_id());
    }
}
