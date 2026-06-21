package com.wip.smartparkingmanagementsys.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wip.smartparkingmanagementsys.dto.Parking_SlotDto;
import com.wip.smartparkingmanagementsys.entity.Parking_Lot;
import com.wip.smartparkingmanagementsys.entity.Parking_Slot;
import com.wip.smartparkingmanagementsys.repository.Parking_LotRepository;
import com.wip.smartparkingmanagementsys.repository.Parking_SlotRepository;
import com.wip.smartparkingmanagementsys.util.Parking_SlotConverter;


@Service
public class Parking_SlotServiceImpl implements Parking_SlotService {
	
    @Autowired
    private Parking_SlotRepository slotrepository;
    
    @Autowired
    private Parking_LotRepository lotrepository;

	@Override
	public Parking_SlotDto addSlot(Parking_SlotDto slotDto) {
        Parking_Slot slot = Parking_SlotConverter.toEntity(slotDto);
        Parking_Lot lot = lotrepository.findById(slotDto.getLot_id())
                .orElseThrow(() -> new RuntimeException("Lot not found"));
        slot.setPl(lot);
        Parking_Slot saved = slotrepository.save(slot);
        return Parking_SlotConverter.toDto(saved);
	}

	@Override
	public List<Parking_SlotDto> getAvailable() {
        return slotrepository.findByStatus("AVAILABLE")
                .stream()
                .map(Parking_SlotConverter::toDto)
                .collect(Collectors.toList());
	}

	@Override
	public List<Parking_SlotDto> getByLot(Long lot_id) {
        return slotrepository.findByPlLotId(lot_id)
                .stream()
                .map(Parking_SlotConverter::toDto)
                .collect(Collectors.toList());
	}

	@Override
	public void updateStatus(Long slot_id, String status) {
        Parking_Slot slot = slotrepository.findById(slot_id)
                .orElseThrow(() -> new RuntimeException("Slot not found"));
        slot.setStatus(status);
        slotrepository.save(slot);
		
	}


	
	
}
