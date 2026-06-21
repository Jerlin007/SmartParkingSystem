package com.wip.smartparkingmanagementsys.dto;

import java.time.LocalDateTime;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;





public class Parking_TransactionDto {

	private Long transaction_id; //PK
	private VehicleDto vehicle; //FK
	private Parking_SlotDto sl; //FK
	private LocalDateTime entry_time;
	private LocalDateTime exit_time;
	private double duration;
	@NotBlank(message = "Status is required")
	private String status;
	private Long vehicle_id;
	private Long slot_id;
	



//	public Parking_TransactionDto(Long transaction_id, VehicleDto vehicle, Parking_SlotDto sl, LocalTime entry_time,
//			LocalTime exit_time, double duration, String status) {
//		super();
//		this.transaction_id = transaction_id;
//		this.vehicle = vehicle;
//		this.sl = sl;
//		this.entry_time = entry_time;
//		this.exit_time = exit_time;
//		this.duration = duration;
//		this.status = status;
//	}
	
	public Parking_TransactionDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(Long transaction_id) {
		this.transaction_id = transaction_id;
	}
	public VehicleDto getVehicle() {
		return vehicle;
	}
	public void setVehicle(VehicleDto vehicle) {
		this.vehicle = vehicle;
	}
	public Parking_SlotDto getSl() {
		return sl;
	}
	public void setSl(Parking_SlotDto sl) {
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

	public void setVehicle_id(Long vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public Long getVehicle_id() {
		// TODO Auto-generated method stub
		return vehicle_id;
	}
	
	public Long getSlot_id() {
		return slot_id;
	}

	public void setSlot_id(Long slot_id) {
		this.slot_id = slot_id;
	}



	
	
	
	
	
}
