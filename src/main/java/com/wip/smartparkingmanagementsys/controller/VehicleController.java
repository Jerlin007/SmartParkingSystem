package com.wip.smartparkingmanagementsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wip.smartparkingmanagementsys.dto.VehicleDto;
import com.wip.smartparkingmanagementsys.service.VehicleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
    @PostMapping("/add")
    public ResponseEntity<VehicleDto> add(@Valid @RequestBody VehicleDto vehicledto) {
        return ResponseEntity.ok(vehicleService.addVehicle(vehicledto));
    }
    
    
    @GetMapping("/user/{user_id}")
    public ResponseEntity<List<VehicleDto>> getByUser(@PathVariable Long user_id) {
        return ResponseEntity.ok(vehicleService.getByUser(user_id));
    }
	
    @GetMapping("/{vehicle_id}")
    public ResponseEntity<VehicleDto> getById(@PathVariable Long vehicle_id) {
        return ResponseEntity.ok(vehicleService.getById(vehicle_id));
    }
	
}
