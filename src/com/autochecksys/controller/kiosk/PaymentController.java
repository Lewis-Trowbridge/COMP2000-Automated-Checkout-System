package com.autochecksys.controller.kiosk;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import com.autochecksys.KeyValuePair;
import com.autochecksys.model.IAutoCheckSysModel;
import com.autochecksys.model.Repository;
import com.autochecksys.view.shared.DisplayPanel;

import javax.swing.*;

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
//begin of modifiable zone................T/7cb6a285-71bb-4734-8130-9bfc6059938e
        PaymentMethodFactory factory = new PaymentMethodFactory();
        paymentMethod = factory.createPaymentMethod(paymentMethodIdentifier, paymentInfo);
        PaymentResult result = paymentMethod.pay(totalToPay);
        displayReceipt(result);
//end of modifiable zone..................E/7cb6a285-71bb-4734-8130-9bfc6059938e
    }

    public void displayReceipt(PaymentResult result) {
//begin of modifiable zone(JavaCode)......C/f56aea0e-d68b-4b1a-abc8-acdefcafe6a9
        // Initiate string builder to build entire receipt string
        StringBuilder receiptString = new StringBuilder();
        if (result.paymentSucceeded){
            // Iterate through all models in basket and add their names and prices to the receipt string using reflection
            for (IAutoCheckSysModel model: basket) {
                try {
                    Integer id = (Integer) model.getClass().getDeclaredMethod("getItemId").invoke(model);
                    Repository.getRepositoryInstance().decrementBoughtItem(id);
                    String name = (String)model.getClass().getDeclaredMethod("getItemName").invoke(model);
                    String price = Float.toString((Float)model.getClass().getDeclaredMethod("getItemPrice").invoke(model));
                    receiptString.append(name).append("     £").append(price).append("\n");
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
            Repository.getRepositoryInstance().saveChanges();
            // Add total to receipt
            receiptString.append("Total paid: £").append(String.format("%.2f", totalToPay)).append("\n");
        }
        // Add payment message - this will contain all relevant information from the payment method
        receiptString.append(result.paymentMessage).append("\n");
        // Display in dialog to simulate the printing of a receipt
        JOptionPane.showMessageDialog(null, receiptString.toString());
    }
//end of modifiable zone(JavaCode)........E/f56aea0e-d68b-4b1a-abc8-acdefcafe6a9
}
