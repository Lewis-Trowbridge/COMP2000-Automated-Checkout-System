package com.autochecksys.controller.kiosk;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardPaymentTest {

    class MockCardPayment extends CardPayment {

        public boolean simulateAcceptClicked;

        public MockCardPayment(int cardNumber, boolean simulateAcceptClicked) {
            super(cardNumber);
            this.simulateAcceptClicked = simulateAcceptClicked;
        }

        @Override
        protected boolean attemptPayment(float amountToPay){
            return simulateAcceptClicked;
        }
    }


    @Test
    public void testBankAcceptPayment(){
        String expectedString = "Payment approved by bank.";
        CardPayment payment = new MockCardPayment(5555, true);
        PaymentResult result = payment.pay(5.00f);
        assertEquals(expectedString, result.paymentMessage);
    }

    @Test
    public void testBankDeclinePayment(){
        String expectedString = "Payment denied by bank.";
        CardPayment payment = new MockCardPayment(5555, false);
        PaymentResult result = payment.pay(5.00f);
        assertEquals(expectedString, result.paymentMessage);
    }
}