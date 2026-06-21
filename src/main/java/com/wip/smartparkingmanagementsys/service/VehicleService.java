package com.wip.smartparkingmanagementsys.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wip.smartparkingmanagementsys.dto.VehicleDto;

@Service
public interface VehicleService {
	
    public VehicleDto addVehicle(VehicleDto vehicledto);
    public List<VehicleDto> getByUser(Long user_id);
    public VehicleDto getById(Long vehicle_id);

}
