package com.autochecksys.view.kiosk;

import javax.swing.JLabel;
import com.autochecksys.KeyValuePair;
import com.autochecksys.view.shared.DisplayPanel;
import com.autochecksys.view.shared.MainFrame;

public class KioskPanel extends DisplayPanel {
    public JLabel lblKiosk;

    public KioskPanel(MainFrame mainFrameToUse) {
//begin of modifiable zone................T/659be782-e128-4838-a1d4-2cacf7025a79
super(mainFrameToUse);

//end of modifiable zone..................E/659be782-e128-4838-a1d4-2cacf7025a79
//begin of modifiable zone(JavaCode)......C/d8e01269-50cd-44cd-9975-4c666c98e662

//end of modifiable zone(JavaCode)........E/d8e01269-50cd-44cd-9975-4c666c98e662
    }

    @Override
    public void setUpComponents() {
//begin of modifiable zone................T/32ed2544-31bb-4081-86f0-64ff77155ffc
        lblKiosk = new JLabel("Test");
        this.add(lblKiosk);
//end of modifiable zone..................E/32ed2544-31bb-4081-86f0-64ff77155ffc
    }

    public void update(KeyValuePair change) {
//begin of modifiable zone(JavaCode)......C/c7c701c6-307c-4400-a10b-4cf1cd2ed4f5

//end of modifiable zone(JavaCode)........E/c7c701c6-307c-4400-a10b-4cf1cd2ed4f5
    }

}
