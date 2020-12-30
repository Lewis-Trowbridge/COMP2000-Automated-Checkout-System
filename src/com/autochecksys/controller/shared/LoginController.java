package com.autochecksys.controller.shared;

import com.autochecksys.KeyValuePair;
import com.autochecksys.controller.kiosk.KioskController;
import com.autochecksys.model.IAutoCheckSysModel;
import com.autochecksys.view.kiosk.KioskPanel;
import com.autochecksys.view.shared.DisplayPanel;

public class LoginController extends AbstractLoginController {
    public DisplayPanel viewToControl;

    public IAutoCheckSysModel[] modelsToUse;

    public boolean checkLogin(String username, String password) {
//begin of modifiable zone(JavaCode)......C/f0fdcaff-94a2-414f-8219-bc1845b932a6

//end of modifiable zone(JavaCode)........E/f0fdcaff-94a2-414f-8219-bc1845b932a6
//begin of modifiable zone................T/f89dd47b-2535-40d8-aadd-c750e55bfabd
        return false;
//end of modifiable zone..................E/f89dd47b-2535-40d8-aadd-c750e55bfabd
    }

    public void updateView(KeyValuePair change) {
//begin of modifiable zone(JavaCode)......C/63373f6d-f0bf-4768-af4a-3e3cd500d1ef

//end of modifiable zone(JavaCode)........E/63373f6d-f0bf-4768-af4a-3e3cd500d1ef
    }

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
//begin of modifiable zone(JavaCode)......C/3cd7f1c3-ccee-4d06-871c-b5ae373e7548
        this.viewToControl = viewToControl;
        this.modelsToUse = modelsToUse;
        viewToControl.setController(this);
//end of modifiable zone(JavaCode)........E/3cd7f1c3-ccee-4d06-871c-b5ae373e7548
    }

}
