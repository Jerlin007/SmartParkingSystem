package com.wip.smartparkingmanagementsys.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reservation_id; //PK
	
	@ManyToOne
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle; //FK
	@ManyToOne
	@JoinColumn(name = "slot_id")
	private Parking_Slot ps; //FK
	private LocalDateTime reservation_time;
	private LocalDateTime start_time;
	private LocalDateTime end_time;
	private String status;
//	public Reservation(Long reservation_id, Vehicle vehicle, Parking_Slot ps, LocalDateTime reservation_time,
//			LocalDateTime start_time, LocalDateTime end_time, String status) {
//		super();
//		this.reservation_id = reservation_id;
//		this.vehicle = vehicle;
//		this.ps = ps;
//		this.reservation_time = reservation_time;
//		this.start_time = start_time;
//		this.end_time = end_time;
//		this.status = status;
//	}
	public Reservation() {
		super();
	}
	public Long getReservation_id() {
		return reservation_id;
	}
	public void setReservation_id(Long reservation_id) {
		this.reservation_id = reservation_id;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public Parking_Slot getPs() {
		return ps;
	}
	public void setPs(Parking_Slot ps) {
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
	
	
	

}
