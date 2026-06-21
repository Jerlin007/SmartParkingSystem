package com.wip.smartparkingmanagementsys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wip.smartparkingmanagementsys.dto.BillingDto;
import com.wip.smartparkingmanagementsys.entity.Billing;
import com.wip.smartparkingmanagementsys.entity.Parking_Transaction;
import com.wip.smartparkingmanagementsys.repository.BillingRepository;
import com.wip.smartparkingmanagementsys.repository.Parking_TransactionRepository;
import com.wip.smartparkingmanagementsys.util.BillingConverter;

@Service
public class BillingServiceImp implements BillingService {
	
    @Autowired
    private BillingRepository billingRepository;

    @Autowired
    private Parking_TransactionRepository transactionRepository;
    
    private static final double RATE_PER_HOUR = 50.0;
    private static final double TAX_PERCENT = 0.18;
	

	@Override
	public BillingDto generateBill(Long transaction_id) {
        Parking_Transaction transaction = transactionRepository.findById(transaction_id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        double amount = transaction.getDuration() * RATE_PER_HOUR;
        double tax = amount * TAX_PERCENT;
        double total = amount + tax;

        Billing billing = new Billing();
        billing.setPt(transaction);
        billing.setAmount(amount);
        billing.setTax(tax);
        billing.setTotal_amount(total);
        billing.setPayment_status("PENDING");

        Billing saved = billingRepository.save(billing);
        return BillingConverter.toDto(saved);
	}

	@Override
	public BillingDto getByTransaction(Long transaction_id) {
		Billing billing = billingRepository.findByPtTransactionId(transaction_id)
                .orElseThrow(() -> new RuntimeException("Bill not found"));
        return BillingConverter.toDto(billing);
	}

	@Override
	public BillingDto getById(Long bill_id) {
        Billing billing = billingRepository.findById(bill_id)
                .orElseThrow(() -> new RuntimeException("Bill not found"));
        return BillingConverter.toDto(billing);
	}

	@Override
	public BillingDto markAsPaid(Long bill_id, String paymentMethod) {
		Billing billing = billingRepository.findById(bill_id)
                .orElseThrow(() -> new RuntimeException("Bill not found"));
        billing.setPayment_status("PAID");
        billing.setPayment_method(paymentMethod);
        Billing saved = billingRepository.save(billing);
        return BillingConverter.toDto(saved);
    }
	

}
