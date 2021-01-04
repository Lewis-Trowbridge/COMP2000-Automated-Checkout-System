package com.autochecksys.controller.kiosk;


public interface IPaymentMethod {
    PaymentResult pay(float amountToPay);

}
