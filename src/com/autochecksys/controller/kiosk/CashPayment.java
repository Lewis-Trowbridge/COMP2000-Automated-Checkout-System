package com.autochecksys.controller.kiosk;


public class CashPayment implements IPaymentMethod {
    private float cashGiven;

    private float change;

    @Override
    public String pay(float amountToPay) {
//begin of modifiable zone(JavaCode)......C/e6eca538-ba2c-4054-a105-8d68d0b75f62

//end of modifiable zone(JavaCode)........E/e6eca538-ba2c-4054-a105-8d68d0b75f62
//begin of modifiable zone................T/e7d8caa4-c3ca-448f-95b6-6cab482c583f
        return "";
//end of modifiable zone..................E/e7d8caa4-c3ca-448f-95b6-6cab482c583f
    }

    private boolean attemptPayment(float amountToPay) {
//begin of modifiable zone(JavaCode)......C/9b1e928a-fb86-4fdf-83fc-943027f64918

//end of modifiable zone(JavaCode)........E/9b1e928a-fb86-4fdf-83fc-943027f64918
//begin of modifiable zone................T/a07e0299-f3df-4cda-9fbe-b9f592ce1d0b
        return false;
//end of modifiable zone..................E/a07e0299-f3df-4cda-9fbe-b9f592ce1d0b
    }

    public CashPayment(float cashGiven) {
//begin of modifiable zone(JavaSuper).....C/586f033c-f7c3-4eea-90c5-fce0ce5ff572

//end of modifiable zone(JavaSuper).......E/586f033c-f7c3-4eea-90c5-fce0ce5ff572
//begin of modifiable zone................T/c49e3798-becd-4056-91d5-94e0c7b9b0b9
        this.cashGiven = cashGiven;
//end of modifiable zone..................E/c49e3798-becd-4056-91d5-94e0c7b9b0b9
    }

}
