package com.wip.smartparkingmanagementsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wip.smartparkingmanagementsys.dto.Parking_LotDto;
import com.wip.smartparkingmanagementsys.service.Parking_LotService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/lots")
public class Parking_LotController {
	
	@Autowired
	private Parking_LotService parkinglotservice;
	
	
	@PostMapping("/add")
	public ResponseEntity<Parking_LotDto> add(@Valid @RequestBody Parking_LotDto parkinglotDto) {
	    return ResponseEntity.ok(parkinglotservice.addLot(parkinglotDto));
	}

}
