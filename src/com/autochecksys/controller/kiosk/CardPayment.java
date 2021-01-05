package com.autochecksys.controller.kiosk;


import javax.swing.*;

public class CardPayment implements IPaymentMethod {
    private int cardNumber;

    @Override
    public PaymentResult pay(float amountToPay) {
//begin of modifiable zone................T/5eb8ef6a-1fef-430a-9016-2f886950b63e
        boolean successful = attemptPayment(amountToPay);
        PaymentResult result = new PaymentResult();
        result.paymentSucceeded = successful;
        if (successful){
            result.paymentMessage = "Paid by card.\nPayment approved by bank.";
        }
        else {
            result.paymentMessage = "Payment denied by bank.";
        }
//end of modifiable zone..................E/5eb8ef6a-1fef-430a-9016-2f886950b63e
//begin of modifiable zone................T/384fd863-ef32-42b1-b86a-7afd1cd7289b
        return result;
//end of modifiable zone..................E/384fd863-ef32-42b1-b86a-7afd1cd7289b
    }

    protected boolean attemptPayment(float amountToPay) {
//begin of modifiable zone................T/eaaca554-35c8-47cd-852a-74fb7caa5c77
        int returned = JOptionPane.showOptionDialog(null, "Card number "+ Integer.toString(cardNumber) + " is attempting to spend £" + String.format("%.2f", amountToPay)
                + ".\nAccept?", "Bank simulation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
//end of modifiable zone..................E/eaaca554-35c8-47cd-852a-74fb7caa5c77
//begin of modifiable zone................T/40ac4d4e-fa88-44a4-8449-223a5aeb52ba
        return returned == JOptionPane.YES_OPTION;
//end of modifiable zone..................E/40ac4d4e-fa88-44a4-8449-223a5aeb52ba
    }

    public CardPayment(int cardNumber) {
//begin of modifiable zone(JavaSuper).....C/4100e1dc-9f0e-4c3e-8ec4-414e4b9b9ec7

//end of modifiable zone(JavaSuper).......E/4100e1dc-9f0e-4c3e-8ec4-414e4b9b9ec7
//begin of modifiable zone................T/cb171a1a-3585-4215-913a-590ea11db17e
        this.cardNumber = cardNumber;
//end of modifiable zone..................E/cb171a1a-3585-4215-913a-590ea11db17e
    }

}
