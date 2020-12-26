package com.autochecksys.main;

import com.autochecksys.controller.shared.AbstractLoginController;
import com.autochecksys.controller.shared.LoginController;
import com.autochecksys.gui.shared.LoginPanel;
import com.autochecksys.gui.shared.MainFrame;

public class Main {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        AbstractLoginController controller = new LoginController();
        LoginPanel panel = new LoginPanel(frame, controller);
        panel.setupAndDisplay();
        frame.setVisible(true);
    }

}
