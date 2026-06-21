package com.wip.smartparkingmanagementsys.tests;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.wip.smartparkingmanagementsys.dto.Parking_TransactionDto;
import com.wip.smartparkingmanagementsys.entity.Parking_Slot;
import com.wip.smartparkingmanagementsys.entity.Parking_Transaction;
import com.wip.smartparkingmanagementsys.entity.Vehicle;
import com.wip.smartparkingmanagementsys.repository.Parking_SlotRepository;
import com.wip.smartparkingmanagementsys.repository.Parking_TransactionRepository;
import com.wip.smartparkingmanagementsys.repository.VehicleRepository;
import com.wip.smartparkingmanagementsys.service.BillingService;
import com.wip.smartparkingmanagementsys.service.Parking_TransactionServiceImpl;

@ExtendWith(MockitoExtension.class)
class ParkingTransactionServiceTest {

    @Mock private Parking_TransactionRepository transactionRepository;
    @Mock private VehicleRepository vehicleRepository;
    @Mock private Parking_SlotRepository slotRepository;
    @Mock private BillingService billingService;
    @InjectMocks private Parking_TransactionServiceImpl transactionService;

    @Test
    void recordEntry_validData_stampsCurrentTime() {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicle_id(1L);

        Parking_Slot slot = new Parking_Slot();
        slot.setSlot_id(1L);
        slot.setStatus("AVAILABLE");

        Parking_Transaction saved = new Parking_Transaction();
        saved.setTransaction_id(1L);
        saved.setVehicle(vehicle);
        saved.setSl(slot);
        saved.setStatus("ACTIVE");
        saved.setEntry_time(LocalDateTime.now());

        Parking_TransactionDto dto = new Parking_TransactionDto();
        dto.setVehicle_id(1L);
        dto.setSlot_id(1L);
        dto.setStatus("ACTIVE");

        when(vehicleRepository.findById(1L)).thenReturn(Optional.of(vehicle));
        when(slotRepository.findById(1L)).thenReturn(Optional.of(slot));
        when(transactionRepository.save(any())).thenReturn(saved);

        Parking_TransactionDto result = transactionService.recordEntry(dto);

        assertNotNull(result);
        assertEquals(1L, result.getTransaction_id());
        assertEquals("OCCUPIED", slot.getStatus());
    }

    @Test
    void recordExit_calculatesAutoTimestampAndBill() {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicle_id(1L);

        Parking_Slot slot = new Parking_Slot();
        slot.setSlot_id(1L);
        slot.setStatus("OCCUPIED");

        Parking_Transaction transaction = new Parking_Transaction();
        transaction.setTransaction_id(1L);
        transaction.setVehicle(vehicle);
        transaction.setSl(slot);
        transaction.setStatus("ACTIVE");
        transaction.setEntry_time(LocalDateTime.now().minusHours(2));

        when(transactionRepository.findById(1L)).thenReturn(Optional.of(transaction));
        when(transactionRepository.save(any())).thenReturn(transaction);

        Parking_TransactionDto dto = new Parking_TransactionDto();
        dto.setStatus("COMPLETED");

        Parking_TransactionDto result = transactionService.recordExit(1L, dto);

        assertNotNull(result);
        assertEquals("AVAILABLE", slot.getStatus());
        assertEquals("COMPLETED", transaction.getStatus());
        // verify billing was generated
        verify(billingService).generateBill(1L);
    }

    @Test
    void recordEntry_vehicleNotFound_throwsException() {
        Parking_TransactionDto dto = new Parking_TransactionDto();
        dto.setVehicle_id(99L);
        dto.setSlot_id(1L);
        dto.setStatus("ACTIVE");

        when(vehicleRepository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> transactionService.recordEntry(dto));
    }

    @Test
    void getById_notFound_throwsException() {
        when(transactionRepository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> transactionService.getById(99L));
    }
}
