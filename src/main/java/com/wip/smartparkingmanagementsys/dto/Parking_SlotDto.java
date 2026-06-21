package com.wip.smartparkingmanagementsys.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Parking_SlotDto {
	

	private Long slot_id; //PK
	@NotBlank(message = "Slot number cannot be Empty")
	private String slot_number;
	@NotBlank(message = "Slot type cannot be Empty")
	private String slot_type;
	@NotNull(message = "Status is required")
	private String status;
	@NotNull(message = "Floor number is required")
	private int floor_number;

	private Parking_LotDto pl;
	private Long lot_id;
//	public Parking_SlotDto(Long slot_id, String slot_number, String slot_type, String status, int floor_number,
//			Parking_LotDto pl) {
//		super();
//		this.slot_id = slot_id;
//		this.slot_number = slot_number;
//		this.slot_type = slot_type;
//		this.status = status;
//		this.floor_number = floor_number;
//		this.pl = pl;
//	}
	
	public Parking_SlotDto() {
		super();
		// TODO Auto-generated constructor stub
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
	public Parking_LotDto getPl() {
		return pl;
	}
	public void setPl(Parking_LotDto pl) {
		this.pl = pl;
	}
	public Long getLot_id() {
		return lot_id;
	}

	public void setLot_id(Long lot_id) {
		this.lot_id = lot_id;
	}
	@Override
	public String toString() {
		return "Parking_Slot [slot_id=" + slot_id + ", slot_number=" + slot_number + ", slot_type=" + slot_type
				+ ", status=" + status + ", floor_number=" + floor_number + ", pl=" + pl + "]";
	}


	
	


}
