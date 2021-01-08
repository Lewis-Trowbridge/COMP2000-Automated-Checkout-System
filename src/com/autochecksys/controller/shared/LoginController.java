package com.autochecksys.controller.shared;

import java.util.List;
import com.autochecksys.KeyValuePair;
import com.autochecksys.controller.admin.AdminDataController;
import com.autochecksys.controller.kiosk.KioskController;
import com.autochecksys.model.IAutoCheckSysModel;
import com.autochecksys.model.Repository;
import com.autochecksys.view.admin.AdminDataPanel;
import com.autochecksys.view.kiosk.KioskPanel;
import com.autochecksys.view.shared.DisplayPanel;

import javax.swing.*;

public class LoginController extends AbstractLoginController {
    public DisplayPanel viewToControl;

    public IAutoCheckSysModel[] modelsToUse;

    @Override
    public void checkLogin(String username, String password) {
//begin of modifiable zone................T/23d065fa-ec53-4276-8726-f9b1bf453017
        // Attempt a login and act on results
        if (Repository.getRepositoryInstance().login(username, password)){
            AdminDataPanel panel = new AdminDataPanel(this.viewToControl.mainFrameToUse);
            panel.setController(new AdminDataController(panel));
            panel.setupAndDisplay();
        }
        else {
            JOptionPane.showMessageDialog(null, "Incorrect login credentials.");
        }
//end of modifiable zone..................E/23d065fa-ec53-4276-8726-f9b1bf453017
    }

    @Override
    public void updateView(KeyValuePair change) {
//begin of modifiable zone(JavaCode)......C/63373f6d-f0bf-4768-af4a-3e3cd500d1ef

//end of modifiable zone(JavaCode)........E/63373f6d-f0bf-4768-af4a-3e3cd500d1ef
    }

    @Override
    public void setModelProperty(KeyValuePair change) {
//begin of modifiable zone(JavaCode)......C/79d4f500-17f5-41b8-a062-e989dc22bf85

//end of modifiable zone(JavaCode)........E/79d4f500-17f5-41b8-a062-e989dc22bf85
    }

    public void checkoutButtonClicked() {
//begin of modifiable zone................T/d175dac0-8632-4105-b164-1e61a802d9c3
        KioskPanel panel = new KioskPanel(viewToControl.mainFrameToUse);
        panel.setController(new KioskController(panel));
        panel.setupAndDisplay();
//end of modifiable zone..................E/d175dac0-8632-4105-b164-1e61a802d9c3
    }

    public LoginController(DisplayPanel viewToControl, IAutoCheckSysModel[] modelsToUse) {
//begin of modifiable zone(JavaSuper).....C/3cd7f1c3-ccee-4d06-871c-b5ae373e7548

//end of modifiable zone(JavaSuper).......E/3cd7f1c3-ccee-4d06-871c-b5ae373e7548
//begin of modifiable zone................T/0f8cb8cc-b0de-457d-af4e-0b610a29200f
        this.viewToControl = viewToControl;
        this.modelsToUse = modelsToUse;
        viewToControl.setController(this);
//end of modifiable zone..................E/0f8cb8cc-b0de-457d-af4e-0b610a29200f
    }

}
