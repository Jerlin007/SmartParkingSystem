package com.wip.smartparkingmanagementsys.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Billing {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bill_id; //PK
	@OneToOne
	@JoinColumn(name = "transaction_id")
	private Parking_Transaction pt; //FK
	private double amount;
	private double tax;
	private double total_amount;
	private String payment_method;
	private String payment_status;
	


	//	public Billing(Long bill_id, Parking_Transaction pt, double amount, double tax, double total_amount,
//			String payment_method, String payment_status) {
//		super();
//		this.bill_id = bill_id;
//		this.pt = pt;
//		this.amount = amount;
//		this.tax = tax;
//		this.total_amount = total_amount;
//		this.payment_method = payment_method;
//		this.payment_status = payment_status;
//	}
//	
	public Billing() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getBill_id() {
		return bill_id;
	}
	public void setBill_id(Long bill_id) {
		this.bill_id = bill_id;
	}
	public Parking_Transaction getPt() {
		return pt;
	}
	public void setPt(Parking_Transaction pt) {
		this.pt = pt;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public double getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	public String getPayment_status() {
		return payment_status;
	}
	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}
	@Override
	public String toString() {
		return "Billing [bill_id=" + bill_id + ", pt=" + pt + ", amount=" + amount + ", tax=" + tax + ", total_amount="
				+ total_amount + ", payment_method=" + payment_method + ", payment_status=" + payment_status + "]";
	}

	
	

	
	
	
}
