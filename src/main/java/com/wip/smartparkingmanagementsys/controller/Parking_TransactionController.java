package com.wip.smartparkingmanagementsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wip.smartparkingmanagementsys.dto.Parking_TransactionDto;
import com.wip.smartparkingmanagementsys.service.Parking_TransactionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/transactions")
public class Parking_TransactionController {
	
	@Autowired
	private Parking_TransactionService transactionservice;
	

    @PostMapping("/entry")
    public ResponseEntity<Parking_TransactionDto> entry(@Valid @RequestBody Parking_TransactionDto transactiondto) {
        return ResponseEntity.ok(transactionservice.recordEntry(transactiondto));
    }

    @PutMapping("/exit/{transaction_id}")
    public ResponseEntity<Parking_TransactionDto> exit(@PathVariable Long transaction_id,
                                                      @RequestBody Parking_TransactionDto transactiondto) {
        return ResponseEntity.ok(transactionservice.recordExit(transaction_id, transactiondto));
    }

    @GetMapping("/{transaction_id}")
    public ResponseEntity<Parking_TransactionDto> getById(@PathVariable Long transaction_id) {
        return ResponseEntity.ok(transactionservice.getById(transaction_id));
    }
	

}
