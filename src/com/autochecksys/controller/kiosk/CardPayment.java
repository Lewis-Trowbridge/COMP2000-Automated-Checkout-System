package com.autochecksys.controller.kiosk;


public class CardPayment implements IPaymentMethod {
    private int cardNumber;

    @Override
    public PaymentResult pay(float amountToPay) {
//begin of modifiable zone(JavaCode)......C/50ae07df-07a4-4955-915b-5c8eab14a0ad

//end of modifiable zone(JavaCode)........E/50ae07df-07a4-4955-915b-5c8eab14a0ad
//begin of modifiable zone................T/384fd863-ef32-42b1-b86a-7afd1cd7289b
        return new PaymentResult();
//end of modifiable zone..................E/384fd863-ef32-42b1-b86a-7afd1cd7289b
    }

    private boolean attemptPayment(float amountToPay) {
//begin of modifiable zone(JavaCode)......C/74c059ca-7a9d-404b-8e3d-6f87a6642ec6

//end of modifiable zone(JavaCode)........E/74c059ca-7a9d-404b-8e3d-6f87a6642ec6
//begin of modifiable zone................T/40ac4d4e-fa88-44a4-8449-223a5aeb52ba
        return false;
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
