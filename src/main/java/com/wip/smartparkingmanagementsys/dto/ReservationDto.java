package com.wip.smartparkingmanagementsys.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class ReservationDto {

	private Long reservation_id; //PK
	private VehicleDto vehicle; //FK
	private Parking_SlotDto ps; //FK
	@NotNull(message = "Reservation Time is required")
	private LocalDateTime reservation_time;
	@NotNull(message = "Start Time is required")
	private LocalDateTime start_time;
	@NotNull(message = "End Time is required")
	private LocalDateTime end_time;
	@NotBlank(message = "Status is required")
	private String status;
	private Long vehicle_id;
	private Long slot_id;
//	public ReservationDto(Long reservation_id, VehicleDto vehicle, Parking_SlotDto ps, LocalTime reservation_time,
//			LocalTime start_time, LocalTime end_time, String status) {
//		super();
//		this.reservation_id = reservation_id;
//		this.vehicle = vehicle;
//		this.ps = ps;
//		this.reservation_time = reservation_time;
//		this.start_time = start_time;
//		this.end_time = end_time;
//		this.status = status;
//	}
	
	public Long getSlot_id() {
		return slot_id;
	}

	public void setSlot_id(Long slot_id) {
		this.slot_id = slot_id;
	}

	public ReservationDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getReservation_id() {
		return reservation_id;
	}
	public void setReservation_id(Long reservation_id) {
		this.reservation_id = reservation_id;
	}
	public VehicleDto getVehicle() {
		return vehicle;
	}
	public void setVehicle(VehicleDto vehicle) {
		this.vehicle = vehicle;
	}
	public Parking_SlotDto getPs() {
		return ps;
	}
	public void setPs(Parking_SlotDto ps) {
		this.ps = ps;
	}
	public LocalDateTime getReservation_time() {
		return reservation_time;
	}
	public void setReservation_time(LocalDateTime reservation_time) {
		this.reservation_time = reservation_time;
	}
	public LocalDateTime getStart_time() {
		return start_time;
	}
	public void setStart_time(LocalDateTime start_time) {
		this.start_time = start_time;
	}
	public LocalDateTime getEnd_time() {
		return end_time;
	}
	public void setEnd_time(LocalDateTime end_time) {
		this.end_time = end_time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Reservation [reservation_id=" + reservation_id + ", vehicle=" + vehicle + ", ps=" + ps + ", status="
				+ status + "]";
	}

	public Long getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(Long vehicle_id) {
		this.vehicle_id = vehicle_id;
	}


	
	
	

}
