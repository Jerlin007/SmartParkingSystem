package com.wip.smartparkingmanagementsys.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wip.smartparkingmanagementsys.dto.Parking_TransactionDto;
import com.wip.smartparkingmanagementsys.entity.Parking_Slot;
import com.wip.smartparkingmanagementsys.entity.Parking_Transaction;
import com.wip.smartparkingmanagementsys.entity.Vehicle;
import com.wip.smartparkingmanagementsys.repository.Parking_SlotRepository;
import com.wip.smartparkingmanagementsys.repository.Parking_TransactionRepository;
import com.wip.smartparkingmanagementsys.repository.VehicleRepository;
import com.wip.smartparkingmanagementsys.util.Parking_TransactionConverter;

@Service
public class Parking_TransactionServiceImpl implements Parking_TransactionService {
	
	
    @Autowired
    private Parking_TransactionRepository transactionRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private Parking_SlotRepository slotRepository;

    @Autowired
    private BillingService billingService;

    @Override
    public Parking_TransactionDto recordEntry(Parking_TransactionDto transactiondto) {
        Parking_Transaction transaction = Parking_TransactionConverter.toEntity(transactiondto);

        Vehicle vehicle = vehicleRepository.findById(transactiondto.getVehicle_id())
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
        Parking_Slot slot = slotRepository.findById(transactiondto.getSlot_id())
                .orElseThrow(() -> new RuntimeException("Slot not found"));

        transaction.setVehicle(vehicle);
        transaction.setSl(slot);
        transaction.setStatus("ACTIVE");

        // Auto stamp current time — no manual entry needed
        transaction.setEntry_time(LocalDateTime.now());

        // Mark slot as OCCUPIED
        slot.setStatus("OCCUPIED");
        slotRepository.save(slot);

        Parking_Transaction saved = transactionRepository.save(transaction);
        return Parking_TransactionConverter.toDto(saved);
    }

    @Override
    public Parking_TransactionDto recordExit(Long transaction_id, Parking_TransactionDto transactiondto) {
        Parking_Transaction transaction = transactionRepository.findById(transaction_id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        // Auto stamp current time as exit — no manual entry needed
        LocalDateTime exitTime = LocalDateTime.now();
        transaction.setExit_time(exitTime);

        // Auto calculate duration in minutes
        long minutes = ChronoUnit.MINUTES.between(transaction.getEntry_time(), exitTime);
        transaction.setDuration(minutes / 60.0);
        transaction.setStatus("COMPLETED");

        // Free up the slot
        Parking_Slot slot = transaction.getSl();
        slot.setStatus("AVAILABLE");
        slotRepository.save(slot);

        Parking_Transaction saved = transactionRepository.save(transaction);

        // Auto generate bill
        billingService.generateBill(saved.getTransaction_id());

        return Parking_TransactionConverter.toDto(saved);
    }

    @Override
    public Parking_TransactionDto getById(Long transaction_id) {
        Parking_Transaction transaction = transactionRepository.findById(transaction_id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        return Parking_TransactionConverter.toDto(transaction);
    }

}
