package com.wip.smartparkingmanagementsys.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicle")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vehicle_id; //PK
	private String vehicle_number;
	private String vehicle_Type;
	private String owner_name;
	private String mobile_number;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user; //FK
	
//	public Vehicle(Long vehicle_id, String vehicle_number, String vehicle_Type, String owner_name, String mobile_number,
//			User user) {
//		super();
//		this.vehicle_id = vehicle_id;
//		this.vehicle_number = vehicle_number;
//		this.vehicle_Type = vehicle_Type;
//		this.owner_name = owner_name;
//		this.mobile_number = mobile_number;
//		this.user = user;
//	}
	public Vehicle() {
		super();
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicle_id=" + vehicle_id + ", vehicle_number=" + vehicle_number + ", vehicle_Type="
				+ vehicle_Type + ", owner_name=" + owner_name + ", mobile_number=" + mobile_number + ", user=" + user
				+ "]";
	}
	
	
	
}
