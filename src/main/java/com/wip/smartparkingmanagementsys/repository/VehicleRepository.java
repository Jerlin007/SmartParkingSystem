package com.wip.smartparkingmanagementsys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.wip.smartparkingmanagementsys.entity.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long>{
	@Query("SELECT v FROM Vehicle v WHERE v.user.user_id = :user_id")
	List<Vehicle> findByUserUserId(@Param("user_id") Long user_id);

	
}
