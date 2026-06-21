package com.wip.smartparkingmanagementsys.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Parking_Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transaction_id; //PK
	@ManyToOne
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle; //FK
	@ManyToOne
	@JoinColumn(name = "slot_id")
	private Parking_Slot sl; //FK
	private LocalDateTime entry_time;
	private LocalDateTime exit_time;
	private double duration;
	private String status;

//	public Parking_Transaction(Long transaction_id, Vehicle vehicle, Parking_Slot sl, LocalDateTime entry_time,
//			LocalDateTime exit_time, double duration, String status) {
//		super();
//		this.transaction_id = transaction_id;
//		this.vehicle = vehicle;
//		this.sl = sl;
//		this.entry_time = entry_time;
//		this.exit_time = exit_time;
//		this.duration = duration;
//		this.status = status;
//	}
	public Parking_Transaction() {
		super();
	}
	public Long getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(Long transaction_id) {
		this.transaction_id = transaction_id;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public Parking_Slot getSl() {
		return sl;
	}
	public void setSl(Parking_Slot sl) {
		this.sl = sl;
	}
	public LocalDateTime getEntry_time() {
		return entry_time;
	}
	public void setEntry_time(LocalDateTime entry_time) {
		this.entry_time = entry_time;
	}
	public LocalDateTime getExit_time() {
		return exit_time;
	}
	public void setExit_time(LocalDateTime exit_time) {
		this.exit_time = exit_time;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Parking_Transaction [transaction_id=" + transaction_id + ", vehicle=" + vehicle + ", sl=" + sl
				+ ", entry_time=" + entry_time + ", exit_time=" + exit_time + ", duration=" + duration + ", status="
				+ status + "]";
	}
	
	
}
