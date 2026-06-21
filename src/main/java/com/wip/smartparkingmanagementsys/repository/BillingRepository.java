package com.wip.smartparkingmanagementsys.repository;





import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wip.smartparkingmanagementsys.entity.Billing;


@Repository
public interface BillingRepository extends JpaRepository<Billing, Long>{

	  @Query("SELECT b FROM Billing b WHERE b.pt.transaction_id = :transaction_id")
	   Optional<Billing> findByPtTransactionId(@Param("transaction_id") Long transaction_id);

}
