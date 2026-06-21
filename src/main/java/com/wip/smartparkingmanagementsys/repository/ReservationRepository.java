package com.wip.smartparkingmanagementsys.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wip.smartparkingmanagementsys.entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	
	

	@Query("SELECT r FROM Reservation r WHERE r.vehicle.vehicle_id = :vehicle_id")
	List<Reservation> findByVehicleVehicleId(@Param("vehicle_id") Long vehicle_id);
	


	
}
