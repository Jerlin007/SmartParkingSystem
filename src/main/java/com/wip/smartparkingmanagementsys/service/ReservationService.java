package com.wip.smartparkingmanagementsys.service;

import java.util.List;



import com.wip.smartparkingmanagementsys.dto.ReservationDto;

public interface ReservationService {
	
	public ReservationDto createReservation(ReservationDto reservationdto);
	public ReservationDto cancelReservation(Long reservation_id);
    public ReservationDto getById(Long reservation_id);
    public List<ReservationDto> getByVehicle(Long vehicle_id);

}