package com.wip.smartparkingmanagementsys.util;

import com.wip.smartparkingmanagementsys.dto.Parking_LotDto;
import com.wip.smartparkingmanagementsys.entity.Parking_Lot;

public class Parking_LotConverter {
	
	
    public static Parking_LotDto toDto(Parking_Lot lot) {
        Parking_LotDto dto = new Parking_LotDto();
        dto.setLot_id(lot.getLot_id());
        dto.setLot_name(lot.getLot_name());
        dto.setLocation(lot.getLocation());
        dto.setTotal_slots(lot.getTotal_slots());
        return dto;
    }

    public static Parking_Lot toEntity(Parking_LotDto parkinglotDto) {
        Parking_Lot lot = new Parking_Lot();
        lot.setLot_name(parkinglotDto.getLot_name());
        lot.setLocation(parkinglotDto.getLocation());
        lot.setTotal_slots(parkinglotDto.getTotal_slots());
        return lot;
    }

}
