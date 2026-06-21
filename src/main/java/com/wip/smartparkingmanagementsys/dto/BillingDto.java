package com.wip.smartparkingmanagementsys.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BillingDto {
	

	private Long bill_id; //PK
	private Parking_TransactionDto pt; //FK
	@NotNull(message = "Amount cannot be Empty")
	private double amount;
	@NotNull(message = "tax amount is required")
	private double tax;
	@NotNull(message = "total amount cannot be Empty")
	private double total_amount;
	@NotBlank(message = "Payment method cannot be Empty")
	private String payment_method;
	@NotBlank(message = "Payment Status is required")
	private String payment_status;
	private Long transaction_id;
	
//	public BillingDto(Long bill_id, Parking_TransactionDto pt, double amount, double tax, double total_amount,
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
	
	public BillingDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getBill_id() {
		return bill_id;
	}
	public void setBill_id(Long bill_id) {
		this.bill_id = bill_id;
	}
	public Parking_TransactionDto getPt() {
		return pt;
	}
	public void setPt(Parking_TransactionDto pt) {
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

	public Long getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(Long transaction_id) {
		
		 this.transaction_id = transaction_id;
		
	}
	
	

	
	
	
}
