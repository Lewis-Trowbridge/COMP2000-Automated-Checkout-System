package com.autochecksys.controller.kiosk;


public class CashPayment implements IPaymentMethod {
    private float cashGiven;

    @Override
    public PaymentResult pay(float amountToPay) {
//begin of modifiable zone................T/b9cc6248-7bff-489c-b5f4-db25261cc745
        PaymentResult result = new PaymentResult();
        float changeLeft = cashGiven - amountToPay;
        if (changeLeft >= 0){
            result.paymentSucceeded = true;
            result.paymentMessage = "Paid by cash.\nPayment successful: £" + String.format("%.2f", changeLeft) + " in change";
        }
        else {
            result.paymentSucceeded = false;
            result.paymentMessage = "Payment failed - not enough money presented.";
        }
//end of modifiable zone..................E/b9cc6248-7bff-489c-b5f4-db25261cc745
//begin of modifiable zone................T/e7d8caa4-c3ca-448f-95b6-6cab482c583f
        return result;
//end of modifiable zone..................E/e7d8caa4-c3ca-448f-95b6-6cab482c583f
    }

    public CashPayment(float cashGiven) {
//begin of modifiable zone(JavaSuper).....C/586f033c-f7c3-4eea-90c5-fce0ce5ff572

//end of modifiable zone(JavaSuper).......E/586f033c-f7c3-4eea-90c5-fce0ce5ff572
//begin of modifiable zone................T/c49e3798-becd-4056-91d5-94e0c7b9b0b9
        this.cashGiven = cashGiven;
//end of modifiable zone..................E/c49e3798-becd-4056-91d5-94e0c7b9b0b9
    }

}
