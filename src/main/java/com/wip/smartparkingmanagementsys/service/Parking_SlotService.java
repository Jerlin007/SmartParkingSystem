package com.wip.smartparkingmanagementsys.service;

import java.util.List;

import com.wip.smartparkingmanagementsys.dto.Parking_SlotDto;

public interface Parking_SlotService {
	
	public Parking_SlotDto addSlot(Parking_SlotDto slotDto);
	public List<Parking_SlotDto> getAvailable();
	public List<Parking_SlotDto> getByLot(Long lot_id);
	public void updateStatus(Long slot_id, String status);
}
