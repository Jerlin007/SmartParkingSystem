package com.wip.smartparkingmanagementsys.service;

import java.util.List;

import com.wip.smartparkingmanagementsys.dto.Parking_LotDto;

public interface Parking_LotService {
	
	public Parking_LotDto addLot(Parking_LotDto parkinglotDto);
    public List<Parking_LotDto> getAll();
    public Parking_LotDto getById(Long id);

}
