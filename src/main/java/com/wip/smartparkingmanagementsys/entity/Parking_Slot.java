package com.wip.smartparkingmanagementsys.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Parking_Slot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long slot_id; //PK
	private String slot_number;
	private String slot_type;
	private String status;
	private int floor_number;
	@ManyToOne
	@JoinColumn(name = "lot_id")
	private Parking_Lot pl;
//	public Parking_Slot(Long slot_id, String slot_number, String slot_type, String status, int floor_number,
//			Parking_Lot pl) {
//		super();
//		this.slot_id = slot_id;
//		this.slot_number = slot_number;
//		this.slot_type = slot_type;
//		this.status = status;
//		this.floor_number = floor_number;
//		this.pl = pl;
//	}
	public Parking_Slot() {
		super();
	}
	
	public Long getSlot_id() {
		return slot_id;
	}
	public void setSlot_id(Long slot_id) {
		this.slot_id = slot_id;
	}
	public String getSlot_number() {
		return slot_number;
	}
	public void setSlot_number(String slot_number) {
		this.slot_number = slot_number;
	}
	public String getSlot_type() {
		return slot_type;
	}
	public void setSlot_type(String slot_type) {
		this.slot_type = slot_type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getFloor_number() {
		return floor_number;
	}
	public void setFloor_number(int floor_number) {
		this.floor_number = floor_number;
	}
	public Parking_Lot getPl() {
		return pl;
	}
	public void setPl(Parking_Lot pl) {
		this.pl = pl;
	}
	@Override
	public String toString() {
		return "Parking_Slot [slot_id=" + slot_id + ", slot_number=" + slot_number + ", slot_type=" + slot_type
				+ ", status=" + status + ", floor_number=" + floor_number + ", pl=" + pl + "]";
	}



	
	


}
