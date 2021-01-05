package com.autochecksys.controller.kiosk;

import com.autochecksys.model.IAutoCheckSysModel;
import com.autochecksys.model.StockItem;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CashPaymentTest {

    CashPayment paymentMethod;

    @Before
    public void setUp() throws Exception {
        paymentMethod = new CashPayment(5.00f);
    }

    @Test
    public void successfulPaymentReturnsSuccessTrue(){
        PaymentResult result = paymentMethod.pay(1.00f);
        assertTrue(result.paymentSucceeded);
    }

    @Test
    public void successfulPaymentReturnsCorrectMessage(){
        String expectedMessage = "Paid by cash.\nPayment successful: £4.00 in change";
        PaymentResult result = paymentMethod.pay(1.00f);
        assertEquals(expectedMessage, result.paymentMessage);
    }

    @Test
    public void unsuccessfulPaymentReturnsSuccessFalse(){
        PaymentResult result = paymentMethod.pay(10.00f);
        assertFalse(result.paymentSucceeded);
    }

    @Test
    public void unsuccessfulPaymentReturnsCorrectMessage(){
        String expectedMessage = "Payment failed - not enough money presented.";
        PaymentResult result = paymentMethod.pay(10.00f);
        assertEquals(expectedMessage, result.paymentMessage);
    }
}