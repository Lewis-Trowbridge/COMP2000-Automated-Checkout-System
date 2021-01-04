package com.autochecksys.controller.kiosk;

import com.autochecksys.KeyValuePair;
import com.autochecksys.model.IAutoCheckSysModel;
import com.autochecksys.model.StockItem;
import com.autochecksys.view.shared.DisplayPanel;
import com.autochecksys.view.shared.MainFrame;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PaymentControllerTest {

    class MockPaymentView extends DisplayPanel{

        public Object updateResult;

        public MockPaymentView(MainFrame frameToDisplayIn) {
            super(frameToDisplayIn);
        }

        @Override
        protected void setUpComponents() {

        }

        @Override
        public void update(KeyValuePair change) {
            switch (change.key){
                case "PaymentResult":
                    updateResult = change.value;
            }
        }
    }

    PaymentController controller;
    MockPaymentView mockView;

    @Before
    public void setUp() throws Exception {
        StockItem item1 = new StockItem();
        item1.setItemPrice(0.99f);
        StockItem item2 = new StockItem();
        item2.setItemPrice(1.50f);
        float totalToPay = item1.getItemPrice() + item2.getItemPrice();
        List<IAutoCheckSysModel> models = new ArrayList<>();
        models.add(item1);
        models.add(item2);
        mockView = new MockPaymentView(new MainFrame());
        controller = new PaymentController(mockView, models, totalToPay);
    }

    @Test
    public void paymentControllerObtainsCardPayment(){
        Object[] paymentInfo = {"44444"};
        controller.pay("Card", paymentInfo);
        assertSame(controller.paymentMethod.getClass(), CardPayment.class);
    }

    @Test
    public void paymentControllerObtainsCashPayment(){
        Object[] paymentInfo = {"0.99"};
        controller.pay("Cash", paymentInfo);
        assertSame(controller.paymentMethod.getClass(), CashPayment.class);
    }


}