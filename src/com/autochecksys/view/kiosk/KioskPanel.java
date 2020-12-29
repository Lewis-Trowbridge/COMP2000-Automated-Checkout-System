package com.autochecksys.view.kiosk;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.autochecksys.KeyValuePair;
import com.autochecksys.view.shared.DisplayPanel;
import com.autochecksys.view.shared.GridBagConstraintsBuilder;
import com.autochecksys.view.shared.MainFrame;

public class KioskPanel extends DisplayPanel {
    public JLabel lblKiosk;

    public JTextField txfBarcodeInput;

    public JButton btnBarcodeEnter;

    public KioskPanel(MainFrame mainFrameToUse) {
//begin of modifiable zone................T/659be782-e128-4838-a1d4-2cacf7025a79
super(mainFrameToUse);

//end of modifiable zone..................E/659be782-e128-4838-a1d4-2cacf7025a79
//begin of modifiable zone(JavaCode)......C/d8e01269-50cd-44cd-9975-4c666c98e662

//end of modifiable zone(JavaCode)........E/d8e01269-50cd-44cd-9975-4c666c98e662
    }

    @Override
    protected void setUpComponents() {
//begin of modifiable zone................T/32ed2544-31bb-4081-86f0-64ff77155ffc
        this.setLayout(new GridBagLayout());
        GridBagConstraintsBuilder builder = new GridBagConstraintsBuilder();
        lblKiosk = new JLabel("Test");
        GridBagConstraints lblKioskConstraints = builder.setGridWidth(4).build();
        txfBarcodeInput = new JTextField();
        GridBagConstraints txfBarcodeInputConstraints = builder.setGridY(1).setGridWidth(3).setFill(GridBagConstraints.HORIZONTAL).build();
        btnBarcodeEnter = new JButton("Go");
        GridBagConstraints btnBarcodeEnterConstraints = builder.setGridX(3).setGridY(1).setFill(GridBagConstraints.HORIZONTAL).build();
        
        
        this.add(lblKiosk, lblKioskConstraints);
        this.add(txfBarcodeInput, txfBarcodeInputConstraints);
        this.add(btnBarcodeEnter, btnBarcodeEnterConstraints);
//end of modifiable zone..................E/32ed2544-31bb-4081-86f0-64ff77155ffc
    }

    public void update(KeyValuePair change) {
//begin of modifiable zone(JavaCode)......C/c7c701c6-307c-4400-a10b-4cf1cd2ed4f5

//end of modifiable zone(JavaCode)........E/c7c701c6-307c-4400-a10b-4cf1cd2ed4f5
    }

}
