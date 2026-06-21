package com.wip.smartparkingmanagementsys.util;

import com.wip.smartparkingmanagementsys.dto.BillingDto;
import com.wip.smartparkingmanagementsys.entity.Billing;

public class BillingConverter {
	
    public static BillingDto toDto(Billing billing) {
    	BillingDto dto = new BillingDto();
        dto.setBill_id(billing.getBill_id());
        dto.setAmount(billing.getAmount());
        dto.setTax(billing.getTax());
        dto.setTotal_amount(billing.getTotal_amount());
        dto.setPayment_method(billing.getPayment_method());
        dto.setPayment_status(billing.getPayment_status());
        dto.setTransaction_id(billing.getPt().getTransaction_id());
        return dto;
    }

    public static Billing toEntity(BillingDto dto) {
        Billing billing = new Billing();
        billing.setAmount(dto.getAmount());
        billing.setTax(dto.getTax());
        billing.setTotal_amount(dto.getTotal_amount());
        billing.setPayment_method(dto.getPayment_method());
        billing.setPayment_status(dto.getPayment_status());
        // transaction set in service
        return billing;
    }
	

}
