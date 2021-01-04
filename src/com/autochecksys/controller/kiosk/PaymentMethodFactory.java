package com.autochecksys.controller.kiosk;

public class PaymentMethodFactory {
    public final static String CARD = "Card";

    public final static String CASH = "Cash";

    public IPaymentMethod createPaymentMethod(String paymentMethod, Object[] paymentInfo) {
//begin of modifiable zone................T/0117c15d-7b02-4590-81e0-32f953947ac5
        switch (paymentMethod){
            case CARD:
                return new CardPayment(Integer.parseInt((String)paymentInfo[0]));
            case CASH:
                return new CashPayment(Float.parseFloat((String)paymentInfo[0]));
            default:
                return new CashPayment(Float.parseFloat((String)paymentInfo[0]));
        }
//end of modifiable zone..................E/0117c15d-7b02-4590-81e0-32f953947ac5
//begin of modifiable zone(JavaReturned)..C/c66607a0-85f3-43aa-9972-90f5ea96cfef

//end of modifiable zone(JavaReturned)....E/c66607a0-85f3-43aa-9972-90f5ea96cfef
    }

}
