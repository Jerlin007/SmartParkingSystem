package com.wip.smartparkingmanagementsys.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wip.smartparkingmanagementsys.dto.Parking_LotDto;
import com.wip.smartparkingmanagementsys.entity.Parking_Lot;
import com.wip.smartparkingmanagementsys.repository.Parking_LotRepository;
import com.wip.smartparkingmanagementsys.util.Parking_LotConverter;


@Service
public class Parking_LotServiceImpl implements Parking_LotService {
	
	@Autowired
	private Parking_LotRepository parkinglotrepository;

	
	
	@Override
	public Parking_LotDto addLot(Parking_LotDto parkinglotDto) {
        Parking_Lot lot = Parking_LotConverter.toEntity(parkinglotDto);
        Parking_Lot saved = parkinglotrepository.save(lot);
        return Parking_LotConverter.toDto(saved);
	}



	@Override
	public List<Parking_LotDto> getAll() {
        return parkinglotrepository.findAll()
                .stream()
                .map(Parking_LotConverter::toDto)
                .collect(Collectors.toList());
	}



	@Override
	public Parking_LotDto getById(Long lot_id) {
        Parking_Lot lot = parkinglotrepository.findById(lot_id)
                .orElseThrow(() -> new RuntimeException("Lot not found"));
        return Parking_LotConverter.toDto(lot);
    }
	

}
