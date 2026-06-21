package com.wip.smartparkingmanagementsys.util;

import com.wip.smartparkingmanagementsys.dto.VehicleDto;
import com.wip.smartparkingmanagementsys.entity.Vehicle;



public class VehicleConverter {
	
	
	public static VehicleDto toDto(Vehicle vehicle) {
		VehicleDto vehicledto = new VehicleDto();
		vehicledto.setVehicle_id(vehicle.getVehicle_id());
		vehicledto.setVehicle_number(vehicle.getVehicle_number());
		vehicledto.setVehicle_Type(vehicle.getVehicle_Type());
		vehicledto.setOwner_name(vehicle.getOwner_name());
		vehicledto.setMobile_number(vehicle.getMobile_number());
		vehicledto.setUser_id(vehicle.getUser().getUser_id());
		return vehicledto;
	}
	
	
	public static Vehicle toEntity(VehicleDto vehicledto) {
		Vehicle vehicle = new Vehicle();
		
		vehicle.setVehicle_number(vehicledto.getVehicle_number());
		vehicle.setVehicle_Type(vehicledto.getVehicle_Type());
		vehicle.setOwner_name(vehicledto.getOwner_name());
		vehicle.setMobile_number(vehicledto.getMobile_number());
		return vehicle;
	}

}
