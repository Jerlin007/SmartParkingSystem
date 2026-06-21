package com.wip.smartparkingmanagementsys.util;

import com.wip.smartparkingmanagementsys.dto.Parking_SlotDto;
import com.wip.smartparkingmanagementsys.entity.Parking_Slot;


	

public class Parking_SlotConverter {

    public static Parking_SlotDto toDto(Parking_Slot slotDto) {
        Parking_SlotDto dto = new Parking_SlotDto();
        dto.setSlot_id(slotDto.getSlot_id());
        dto.setSlot_number(slotDto.getSlot_number());
        dto.setSlot_type(slotDto.getSlot_type());
        dto.setStatus(slotDto.getStatus());
        dto.setFloor_number(slotDto.getFloor_number());
        dto.setLot_id(slotDto.getPl().getLot_id());
        return dto;
    }

    public static Parking_Slot toEntity(Parking_SlotDto slotdto) {
    	Parking_Slot slot = new Parking_Slot();
        slot.setSlot_number(slotdto.getSlot_number());
        slot.setSlot_type(slotdto.getSlot_type());
        slot.setStatus(slotdto.getStatus());
        slot.setFloor_number(slotdto.getFloor_number());
        // parkingLot set in service
        return slot;
    }
}




