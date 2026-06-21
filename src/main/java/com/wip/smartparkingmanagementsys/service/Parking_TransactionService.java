package com.wip.smartparkingmanagementsys.service;

import com.wip.smartparkingmanagementsys.dto.Parking_TransactionDto;

public interface Parking_TransactionService {
	
    public Parking_TransactionDto recordEntry(Parking_TransactionDto transactiondto);
    public Parking_TransactionDto recordExit(Long transaction_id, Parking_TransactionDto transactiondto);
    public Parking_TransactionDto getById(Long transaction_id);

}
