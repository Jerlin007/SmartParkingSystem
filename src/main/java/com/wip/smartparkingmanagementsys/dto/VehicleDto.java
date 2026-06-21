package com.wip.smartparkingmanagementsys.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class VehicleDto {
	

	private Long vehicle_id; //PK
	@NotBlank(message = "Vehicle number is Required")
	private String vehicle_number;
	@NotBlank(message = "Vehicle type is Required")
	private String vehicle_Type;
	@NotBlank(message = "Owner name is Required")
	private String owner_name;
	@NotBlank(message = "Phone number cannot be empty")
	@Size(max = 10, message = "Phone Number Must contain 10 character")
	private String mobile_number;
	private Long user_id;
	private UserDto user; //FK
	
//	public VehicleDto(Long vehicle_id, String vehicle_number, String vehicle_Type, String owner_name, String mobile_number,
//			UserDto user) {
//		super();
//		this.vehicle_id = vehicle_id;
//		this.vehicle_number = vehicle_number;
//		this.vehicle_Type = vehicle_Type;
//		this.owner_name = owner_name;
//		this.mobile_number = mobile_number;
//		this.user = user;
//	}
	
	public VehicleDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getVehicle_id() {
		return vehicle_id;
	}
	public void setVehicle_id(Long vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	public String getVehicle_number() {
		return vehicle_number;
	}
	public void setVehicle_number(String vehicle_number) {
		this.vehicle_number = vehicle_number;
	}
	public String getVehicle_Type() {
		return vehicle_Type;
	}
	public void setVehicle_Type(String vehicle_Type) {
		this.vehicle_Type = vehicle_Type;
	}
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	public String getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Vehicle [vehicle_id=" + vehicle_id + ", vehicle_number=" + vehicle_number + ", vehicle_Type="
				+ vehicle_Type + ", owner_name=" + owner_name + ", mobile_number=" + mobile_number + ", user=" + user
				+ "]";
	}

    public Long getUser_id() {
    	return user_id; 
    }
    public void setUser_id(Long user_id) {
    	this.user_id = user_id; 
    }


	
	
}
