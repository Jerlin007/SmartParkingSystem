package com.wip.smartparkingmanagementsys.dto;

import jakarta.validation.constraints.NotBlank;

public class Parking_LotDto {
	

	private Long lot_id; //PK
	@NotBlank(message = "lot name cannot be Empty")
	private String lot_name;
	@NotBlank(message = "location cannot be Empty")
	private String location;
	private int total_slots;
//	public Parking_LotDto(Long lot_id, String lot_name, String location, int total_slots) {
//		super();
//		this.lot_id = lot_id;
//		this.lot_name = lot_name;
//		this.location = location;
//		this.total_slots = total_slots;
//	}
	
	public Parking_LotDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getLot_id() {
		return lot_id;
	}
	public void setLot_id(Long lot_id) {
		this.lot_id = lot_id;
	}
	public String getLot_name() {
		return lot_name;
	}
	public void setLot_name(String lot_name) {
		this.lot_name = lot_name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getTotal_slots() {
		return total_slots;
	}
	public void setTotal_slots(int total_slots) {
		this.total_slots = total_slots;
	}
	@Override
	public String toString() {
		return "Parking_Lot [lot_id=" + lot_id + ", lot_name=" + lot_name + ", location=" + location + ", total_slots="
				+ total_slots + "]";
	}
	
	

}
