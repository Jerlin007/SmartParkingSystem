package com.wip.smartparkingmanagementsys.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wip.smartparkingmanagementsys.entity.Parking_Lot;


@Repository
public interface Parking_LotRepository  extends JpaRepository<Parking_Lot, Long>{

	

}
