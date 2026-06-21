package com.wip.smartparkingmanagementsys.repository;



import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.wip.smartparkingmanagementsys.entity.Parking_Slot;


@Repository
public interface Parking_SlotRepository  extends JpaRepository<Parking_Slot, Long> {
	
    List<Parking_Slot> findByStatus(String status);



    @Query("SELECT s FROM Parking_Slot s WHERE s.pl.lot_id = :lot_id")
    List<Parking_Slot> findByPlLotId(@Param("lot_id") Long lot_id);



	



	
	

}
