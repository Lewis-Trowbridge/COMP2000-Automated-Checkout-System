package com.autochecksys.view.kiosk;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import javax.swing.*;

import com.autochecksys.KeyValuePair;
import com.autochecksys.view.shared.DisplayPanel;
import com.autochecksys.view.shared.GridBagConstraintsBuilder;
import com.autochecksys.view.shared.MainFrame;

public class PaymentPanel extends DisplayPanel {
    public JLabel lblPaymentTitle;

    public JComboBox<String> cbxPaymentMethodSelection;

    public JTextField txfPriceInput;

    public JButton btnPay;

    public PaymentPanel(MainFrame mainFrameToUse) {
//begin of modifiable zone................T/1b155cef-0ad2-443a-b264-d76f0b150598
super(mainFrameToUse);

//end of modifiable zone..................E/1b155cef-0ad2-443a-b264-d76f0b150598
//begin of modifiable zone................T/14877571-3788-4f4b-93e2-4f8a78d1996c
        
//end of modifiable zone..................E/14877571-3788-4f4b-93e2-4f8a78d1996c
    }

    @Override
    protected void setUpComponents() {
//begin of modifiable zone................T/7b794898-f1b7-465b-af07-c42d5d2542ca
        this.setLayout(new GridBagLayout());
        GridBagConstraintsBuilder builder = new GridBagConstraintsBuilder();
        lblPaymentTitle = new JLabel("Please select your payment method:");
        GridBagConstraints lblPaymentTitleConstraints = builder.build();
        
        String[] paymentOptionStrings = {"Card", "Cash"};
        cbxPaymentMethodSelection = new JComboBox<>(paymentOptionStrings);
        GridBagConstraints cbxPaymentMethodSelectionConstraints = builder.setGridY(1).build();
        
        JPanel pnlPayControls = new JPanel();
        pnlPayControls.setLayout(new GridBagLayout());
        GridBagConstraints pnlPayControlsConstraints = builder.setGridY(2).setFill(GridBagConstraints.HORIZONTAL).build();
        
        txfPriceInput = new JTextField();
        GridBagConstraints txfPriceInputConstraints = builder.setFill(GridBagConstraints.HORIZONTAL).build();
        
        btnPay = new JButton("Pay");
        GridBagConstraints btnPayConstraints = builder.setGridX(1).setFill(GridBagConstraints.HORIZONTAL).build();
        
        this.add(lblPaymentTitle, lblPaymentTitleConstraints);
        this.add(cbxPaymentMethodSelection, cbxPaymentMethodSelectionConstraints);
        pnlPayControls.add(txfPriceInput, txfPriceInputConstraints);
        pnlPayControls.add(btnPay, btnPayConstraints);
        this.add(pnlPayControls, pnlPayControlsConstraints);

        setUpEventListeners();
//end of modifiable zone..................E/7b794898-f1b7-465b-af07-c42d5d2542ca
    }

    @Override
    public void update(KeyValuePair change) {
//begin of modifiable zone(JavaCode)......C/f0f9522f-9fee-4b89-a5e2-de6ba3f2ed77

//end of modifiable zone(JavaCode)........E/f0f9522f-9fee-4b89-a5e2-de6ba3f2ed77
    }

    private void setUpEventListeners() {
//begin of modifiable zone(JavaCode)......C/5fe69ed9-5b05-44ac-8814-f7c5202100a3
        btnPay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Object[] paymentInfoToSend = {txfPriceInput.getText()};
                    controller.getClass().getDeclaredMethod("pay", String.class, Object[].class).invoke(controller, (String)cbxPaymentMethodSelection.getSelectedItem(), paymentInfoToSend);
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException noSuchMethodException) {
                    noSuchMethodException.printStackTrace();
                }
            }
        });
//end of modifiable zone(JavaCode)........E/5fe69ed9-5b05-44ac-8814-f7c5202100a3
    }

}
