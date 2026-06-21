package com.wip.smartparkingmanagementsys.util;

import com.wip.smartparkingmanagementsys.dto.Parking_TransactionDto;
import com.wip.smartparkingmanagementsys.entity.Parking_Transaction;

public class Parking_TransactionConverter {
	
    public static Parking_TransactionDto toDto(Parking_Transaction transaction) {
    	Parking_TransactionDto dto = new Parking_TransactionDto();
        dto.setTransaction_id(transaction.getTransaction_id());
        dto.setEntry_time(transaction.getEntry_time());
        dto.setExit_time(transaction.getExit_time());
        dto.setDuration(transaction.getDuration());
        dto.setStatus(transaction.getStatus());
        dto.setVehicle_id(transaction.getVehicle().getVehicle_id());
        dto.setSlot_id(transaction.getSl().getSlot_id());
        return dto;
    }

    public static Parking_Transaction toEntity(Parking_TransactionDto parkingtransactiondto) {
        Parking_Transaction transaction = new Parking_Transaction();
        transaction.setEntry_time(parkingtransactiondto.getEntry_time());
        transaction.setExit_time(parkingtransactiondto.getExit_time());
        transaction.setDuration(parkingtransactiondto.getDuration());
        transaction.setStatus(parkingtransactiondto.getStatus());
        // vehicle and slot set in service
        return transaction;
    }

}
