package com.wip.smartparkingmanagementsys.tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.wip.smartparkingmanagementsys.dto.BillingDto;
import com.wip.smartparkingmanagementsys.entity.Billing;
import com.wip.smartparkingmanagementsys.entity.Parking_Slot;
import com.wip.smartparkingmanagementsys.entity.Parking_Transaction;
import com.wip.smartparkingmanagementsys.entity.Vehicle;
import com.wip.smartparkingmanagementsys.repository.BillingRepository;
import com.wip.smartparkingmanagementsys.repository.Parking_TransactionRepository;
import com.wip.smartparkingmanagementsys.service.BillingServiceImp;

@ExtendWith(MockitoExtension.class)
class BillingServiceTest {

    @Mock private BillingRepository billingRepository;
    @Mock private Parking_TransactionRepository transactionRepository;
    @InjectMocks private BillingServiceImp billingService;

    private Parking_Transaction buildTransaction(double durationHours) {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicle_id(1L);

        Parking_Slot slot = new Parking_Slot();
        slot.setSlot_id(1L);

        Parking_Transaction t = new Parking_Transaction();
        t.setTransaction_id(1L);
        t.setVehicle(vehicle);
        t.setSl(slot);
        t.setEntry_time(LocalDateTime.now().minusHours((long) durationHours));
        t.setExit_time(LocalDateTime.now());
        t.setDuration(durationHours);
        t.setStatus("COMPLETED");
        return t;
    }

    @Test
    void generateBill_2hours_correctAmountAndTax() {
        Parking_Transaction transaction = buildTransaction(2.0);

        Billing saved = new Billing();
        saved.setBill_id(1L);
        saved.setPt(transaction);
        saved.setAmount(100.0);   // 2 hours x 50
        saved.setTax(18.0);       // 18%
        saved.setTotal_amount(118.0);
        saved.setPayment_method("UPI");
        saved.setPayment_status("PENDING");

        when(transactionRepository.findById(1L)).thenReturn(Optional.of(transaction));
        when(billingRepository.save(any())).thenReturn(saved);

        BillingDto result = billingService.generateBill(1L);

        assertNotNull(result);
        assertEquals(100.0, result.getAmount());
        assertEquals(18.0, result.getTax());
        assertEquals(118.0, result.getTotal_amount());
        assertEquals("PENDING", result.getPayment_status());
        assertEquals("UPI", result.getPayment_method());
    }

    @Test
    void markAsPaid_updatesPaidStatus() {
        Parking_Transaction transaction = buildTransaction(1.0);

        Billing billing = new Billing();
        billing.setBill_id(1L);
        billing.setPt(transaction);
        billing.setPayment_status("PENDING");
        billing.setPayment_method("UPI");
        billing.setAmount(50.0);
        billing.setTax(9.0);
        billing.setTotal_amount(59.0);

        when(billingRepository.findById(1L)).thenReturn(Optional.of(billing));
        when(billingRepository.save(any())).thenAnswer(i -> i.getArguments()[0]);

        BillingDto result = billingService.markAsPaid(1L, "UPI");

        assertEquals("PAID", result.getPayment_status());
    }

    @Test
    void generateBill_transactionNotFound_throwsException() {
        when(transactionRepository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> billingService.generateBill(99L));
    }

    @Test
    void markAsPaid_billNotFound_throwsException() {
        when(billingRepository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> billingService.markAsPaid(99L, "UPI"));
    }
}
