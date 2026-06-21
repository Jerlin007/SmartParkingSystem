package com.wip.smartparkingmanagementsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wip.smartparkingmanagementsys.dto.ReservationDto;
import com.wip.smartparkingmanagementsys.service.ReservationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
	
	@Autowired
	private ReservationService reservationservice;
	
    @PostMapping("/add")
    public ResponseEntity<ReservationDto> add(@Valid @RequestBody ReservationDto reservationdto) {
        return ResponseEntity.ok(reservationservice.createReservation(reservationdto));
    }
    
    @PutMapping("/cancel/{id}")
    public ResponseEntity<ReservationDto> cancel(@PathVariable Long id) {
        return ResponseEntity.ok(reservationservice.cancelReservation(id));
    }
    
    @GetMapping("/vehicle/{vehicle_id}")
    public ResponseEntity<List<ReservationDto>> getByVehicle(@PathVariable Long vehicle_id) {
        return ResponseEntity.ok(reservationservice.getByVehicle(vehicle_id));
    }
	

}
