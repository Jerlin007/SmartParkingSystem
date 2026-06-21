package com.wip.smartparkingmanagementsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wip.smartparkingmanagementsys.dto.BillingDto;
import com.wip.smartparkingmanagementsys.service.BillingService;

@RestController
@RequestMapping("/billing")
public class BillingController {
	
    @Autowired
    private BillingService billingService;
    
    
    @GetMapping("/{bill_id}")
    public ResponseEntity<BillingDto> getById(@PathVariable Long billing_id) {
        return ResponseEntity.ok(billingService.getByTransaction(billing_id));
    }

    @GetMapping("/transaction/{transaction_id}")
    public ResponseEntity<BillingDto> getByTransaction(@PathVariable Long transaction_id) {
        return ResponseEntity.ok(billingService.getByTransaction(transaction_id));
    }
    
    @PutMapping("/pay/{bill_id}")
    public ResponseEntity<BillingDto> markAsPaid(
            @PathVariable Long bill_id,
            @RequestParam(defaultValue = "UPI") String paymentMethod) {
        return ResponseEntity.ok(billingService.markAsPaid(bill_id, paymentMethod));
    }

}
