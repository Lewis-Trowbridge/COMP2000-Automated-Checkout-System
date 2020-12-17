package com.autochecksys.gui.shared;

import javax.swing.*;
import javax.swing.JPanel;
import java.awt.*;

public class MainFrame extends JFrame {
    private JPanel topLevelPanel;

    public MainFrame(){
        setContentPane(topLevelPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));
        pack();
    }

}
