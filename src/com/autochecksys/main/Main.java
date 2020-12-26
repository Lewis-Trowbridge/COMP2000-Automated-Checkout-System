package com.autochecksys.main;

import com.autochecksys.controller.shared.AbstractLoginController;
import com.autochecksys.controller.shared.LoginController;
import com.autochecksys.model.IAutoCheckSysModel;
import com.autochecksys.view.shared.LoginPanel;
import com.autochecksys.view.shared.MainFrame;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        LoginPanel panel = new LoginPanel(frame);
        AbstractLoginController controller = new LoginController(panel, new IAutoCheckSysModel[0]);
        panel.setupAndDisplay();
        frame.setVisible(true);
    }

}
