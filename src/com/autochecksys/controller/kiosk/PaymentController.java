package com.autochecksys.controller.kiosk;

import java.util.List;
import com.autochecksys.KeyValuePair;
import com.autochecksys.model.IAutoCheckSysModel;
import com.autochecksys.view.shared.DisplayPanel;

public class PaymentController extends AbstractPaymentController {
    public DisplayPanel viewToControl;

    public List<IAutoCheckSysModel> basket;

    public float totalToPay;

    public IPaymentMethod paymentMethod;

    public PaymentController(DisplayPanel viewToControl, List<IAutoCheckSysModel> basket, float totalToPay) {
//begin of modifiable zone(JavaSuper).....C/2d877c05-6d69-4e9f-b197-42b3b3cbf0c2

//end of modifiable zone(JavaSuper).......E/2d877c05-6d69-4e9f-b197-42b3b3cbf0c2
//begin of modifiable zone................T/62a423d6-4d20-4756-a5a2-5ed8d473012c
        this.viewToControl = viewToControl;
        this.basket = basket;
        this.totalToPay = totalToPay;
//end of modifiable zone..................E/62a423d6-4d20-4756-a5a2-5ed8d473012c
    }

    @Override
    public void updateView(KeyValuePair change) {
//begin of modifiable zone(JavaCode)......C/d030ee59-791c-4612-9be4-731049affe21

//end of modifiable zone(JavaCode)........E/d030ee59-791c-4612-9be4-731049affe21
    }

    @Override
    public void setModelProperty(KeyValuePair change) {
//begin of modifiable zone(JavaCode)......C/18588d83-a457-4d75-953f-b7a75861e5c1

//end of modifiable zone(JavaCode)........E/18588d83-a457-4d75-953f-b7a75861e5c1
    }

    public void pay(String paymentMethodIdentifier, Object[] paymentInfo) {
//begin of modifiable zone(JavaCode)......C/92f3ac49-563c-4927-91f1-7c24d475b166
        PaymentMethodFactory factory = new PaymentMethodFactory();
        paymentMethod = factory.createPaymentMethod(paymentMethodIdentifier, paymentInfo);
        PaymentResult result = paymentMethod.pay(totalToPay);

//end of modifiable zone(JavaCode)........E/92f3ac49-563c-4927-91f1-7c24d475b166
    }

}
