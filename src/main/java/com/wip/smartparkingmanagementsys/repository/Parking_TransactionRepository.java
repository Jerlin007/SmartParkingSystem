package com.wip.smartparkingmanagementsys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wip.smartparkingmanagementsys.entity.Parking_Transaction;

@Repository
public interface Parking_TransactionRepository extends JpaRepository<Parking_Transaction ,Long> {

}
