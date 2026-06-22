package com.wip.smartparkingmanagementsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wip.smartparkingmanagementsys.dto.Parking_SlotDto;
import com.wip.smartparkingmanagementsys.service.Parking_SlotService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/slots")
public class Parking_SlotController {
	
    @Autowired
    private Parking_SlotService slotservice;

    @PostMapping("/add")
    public ResponseEntity<Parking_SlotDto> add(@Valid @RequestBody Parking_SlotDto slotDto) {
        return ResponseEntity.ok(slotservice.addSlot(slotDto));
    }
    
    @GetMapping("/available")
    public ResponseEntity<List<Parking_SlotDto>> getAvailable() {
        return ResponseEntity.ok(slotservice.getAvailable());
    }

    @GetMapping("/lot/{lot_id}")
    public ResponseEntity<List<Parking_SlotDto>> getByLot(@PathVariable Long lot_id) {
        return ResponseEntity.ok(slotservice.getByLot(lot_id));
    }

    @PutMapping("/status/{slot_id}")
    public ResponseEntity<String> updateStatus(@PathVariable Long slot_id,
                                               @RequestParam String status) {
        slotservice.updateStatus(slot_id, status);
        return ResponseEntity.ok("Status updated");
    }
    
    // Returns the actual error message to frontend instead of generic 500 error
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleException(RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
