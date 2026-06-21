package com.wip.smartparkingmanagementsys.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wip.smartparkingmanagementsys.dto.VehicleDto;
import com.wip.smartparkingmanagementsys.entity.User;
import com.wip.smartparkingmanagementsys.entity.Vehicle;
import com.wip.smartparkingmanagementsys.repository.UserRepository;
import com.wip.smartparkingmanagementsys.repository.VehicleRepository;
import com.wip.smartparkingmanagementsys.util.VehicleConverter;

@Service
public class VehicleServiceImpl implements VehicleService {
	
	@Autowired
	private VehicleRepository vehiclerepository;
	
	@Autowired
	private UserRepository userrepository;

	@Override
	public VehicleDto addVehicle(VehicleDto vehicledto) {
		Vehicle vehicle = VehicleConverter.toEntity(vehicledto);
		User User = userrepository.findById(vehicledto.getUser_id())
				.orElseThrow(() -> new RuntimeException("User not found"));
		vehicle.setUser(User);
		Vehicle saved = vehiclerepository.save(vehicle);
		return VehicleConverter.toDto(saved);
	}

	@Override
	public List<VehicleDto> getByUser(Long user_id) {
		List<Vehicle> vehicle = vehiclerepository.findByUserUserId(user_id);
	    return vehicle.stream()
	    		.map(VehicleConverter::toDto)
	    		.collect(Collectors.toList());
	}

	@Override
	public VehicleDto getById(Long vehicle_id) {
        Vehicle vehicle = vehiclerepository.findById(vehicle_id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
        return VehicleConverter.toDto(vehicle);
	}


	

}
