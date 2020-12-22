package com.autochecksys.main;

import com.autochecksys.gui.shared.LoginPanel;
import com.autochecksys.gui.shared.MainFrame;

public class Main {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        LoginPanel panel = new LoginPanel(frame);
        panel.setupAndDisplay();
        frame.setVisible(true);
    }

}
