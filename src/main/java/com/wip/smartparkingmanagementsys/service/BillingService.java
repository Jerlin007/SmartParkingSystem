package com.wip.smartparkingmanagementsys.service;

import com.wip.smartparkingmanagementsys.dto.BillingDto;

public interface BillingService {

	public BillingDto generateBill(Long transaction_id);
	public BillingDto getByTransaction(Long transactionId);
    BillingDto getById(Long bill_id);

    BillingDto markAsPaid(Long bill_id, String paymentMethod);

}
