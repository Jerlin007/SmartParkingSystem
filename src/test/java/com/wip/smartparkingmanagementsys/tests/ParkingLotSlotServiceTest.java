package com.wip.smartparkingmanagementsys.tests;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.wip.smartparkingmanagementsys.dto.Parking_LotDto;
import com.wip.smartparkingmanagementsys.dto.Parking_SlotDto;
import com.wip.smartparkingmanagementsys.entity.Parking_Lot;
import com.wip.smartparkingmanagementsys.entity.Parking_Slot;
import com.wip.smartparkingmanagementsys.repository.Parking_LotRepository;
import com.wip.smartparkingmanagementsys.repository.Parking_SlotRepository;
import com.wip.smartparkingmanagementsys.service.Parking_LotServiceImpl;
import com.wip.smartparkingmanagementsys.service.Parking_SlotServiceImpl;

@ExtendWith(MockitoExtension.class)
class ParkingLotSlotServiceTest {

    @Mock private Parking_LotRepository lotRepository;
    @Mock private Parking_SlotRepository slotRepository;
    @InjectMocks private Parking_LotServiceImpl lotService;
    @InjectMocks private Parking_SlotServiceImpl slotService;

    // ── LOT TESTS ──

    @Test
    void addLot_savesAndReturnsDto() {
        Parking_Lot lot = new Parking_Lot();
        lot.setLot_id(1L);
        lot.setLot_name("Main Lot");
        lot.setLocation("Chennai");
        lot.setTotal_slots(50);

        Parking_LotDto dto = new Parking_LotDto();
        dto.setLot_name("Main Lot");
        dto.setLocation("Chennai");
        dto.setTotal_slots(50);

        when(lotRepository.save(any())).thenReturn(lot);

        Parking_LotDto result = lotService.addLot(dto);

        assertNotNull(result);
        assertEquals("Main Lot", result.getLot_name());
        assertEquals(1L, result.getLot_id());
    }

    // ── SLOT TESTS ──

    @Test
    void addSlot_savesAndReturnsDto() {
        Parking_Lot lot = new Parking_Lot();
        lot.setLot_id(1L);
        lot.setTotal_slots(10); // FIX: set total_slots > 0

        Parking_Slot slot = new Parking_Slot();
        slot.setSlot_id(1L);
        slot.setSlot_number("A1");
        slot.setSlot_type("CAR");
        slot.setStatus("AVAILABLE");
        slot.setFloor_number(1);
        slot.setPl(lot);

        Parking_SlotDto dto = new Parking_SlotDto();
        dto.setSlot_number("A1");
        dto.setSlot_type("CAR");
        dto.setStatus("AVAILABLE");
        dto.setFloor_number(1);
        dto.setLot_id(1L);

        when(lotRepository.findById(1L)).thenReturn(Optional.of(lot));
        when(slotRepository.countByLotId(1L)).thenReturn(0L); // FIX: mock count to return 0 (no slots yet)
        when(slotRepository.save(any())).thenReturn(slot);

        Parking_SlotDto result = slotService.addSlot(dto);

        assertNotNull(result);
        assertEquals("A1", result.getSlot_number());
    }

    @Test
    void addSlot_capacityFull_throwsException() {
        Parking_Lot lot = new Parking_Lot();
        lot.setLot_id(1L);
        lot.setTotal_slots(5); // lot has 5 slots capacity

        Parking_SlotDto dto = new Parking_SlotDto();
        dto.setSlot_number("A6");
        dto.setSlot_type("CAR");
        dto.setStatus("AVAILABLE");
        dto.setFloor_number(1);
        dto.setLot_id(1L);

        when(lotRepository.findById(1L)).thenReturn(Optional.of(lot));
        when(slotRepository.countByLotId(1L)).thenReturn(5L); // already 5 slots = full

        assertThrows(RuntimeException.class, () -> slotService.addSlot(dto));
    }

    @Test
    void getAvailableSlots_returnsOnlyAvailable() {
        Parking_Lot lot = new Parking_Lot();
        lot.setLot_id(1L);

        Parking_Slot slot = new Parking_Slot();
        slot.setSlot_id(1L);
        slot.setSlot_number("A1");
        slot.setSlot_type("CAR");
        slot.setStatus("AVAILABLE");
        slot.setFloor_number(1);
        slot.setPl(lot);

        when(slotRepository.findByStatus("AVAILABLE")).thenReturn(List.of(slot));

        List<Parking_SlotDto> result = slotService.getAvailable();

        assertFalse(result.isEmpty());
        assertEquals("AVAILABLE", result.get(0).getStatus());
    }

    @Test
    void updateSlotStatus_changesStatus() {
        Parking_Lot lot = new Parking_Lot();
        lot.setLot_id(1L);

        Parking_Slot slot = new Parking_Slot();
        slot.setSlot_id(1L);
        slot.setStatus("AVAILABLE");
        slot.setPl(lot);

        when(slotRepository.findById(1L)).thenReturn(Optional.of(slot));
        when(slotRepository.save(any())).thenReturn(slot);

        slotService.updateStatus(1L, "OCCUPIED");

        assertEquals("OCCUPIED", slot.getStatus());
        verify(slotRepository).save(slot);
    }

    @Test
    void getByLot_returnsSlotList() {
        Parking_Lot lot = new Parking_Lot();
        lot.setLot_id(1L);

        Parking_Slot slot = new Parking_Slot();
        slot.setSlot_id(1L);
        slot.setSlot_number("A1");
        slot.setSlot_type("CAR");
        slot.setStatus("AVAILABLE");
        slot.setFloor_number(1);
        slot.setPl(lot);

        when(slotRepository.findByPlLotId(1L)).thenReturn(List.of(slot));

        List<Parking_SlotDto> result = slotService.getByLot(1L);

        assertFalse(result.isEmpty());
        assertEquals("A1", result.get(0).getSlot_number());
    }
}
