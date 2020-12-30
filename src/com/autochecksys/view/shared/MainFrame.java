package com.autochecksys.view.shared;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public JPanel topLevelPanel;

    public MainFrame() {
//begin of modifiable zone................T/af4ecf0a-a6cb-41bb-807c-671a9370ae70
setContentPane(topLevelPanel);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setPreferredSize(new Dimension(500, 500));
pack();

//end of modifiable zone..................E/af4ecf0a-a6cb-41bb-807c-671a9370ae70
//begin of modifiable zone(JavaCode)......C/f89a04fd-8949-43f4-b31f-c5f5b506d341

//end of modifiable zone(JavaCode)........E/f89a04fd-8949-43f4-b31f-c5f5b506d341
    }

    public void displayPanel(DisplayPanel panelToDisplay) {
//begin of modifiable zone................T/46aa3c1e-d34e-44eb-beba-7646c87eec74
        GridBagConstraintsBuilder builder = new GridBagConstraintsBuilder();
        topLevelPanel.removeAll();
        GridBagConstraints constraints = builder.setFill(GridBagConstraints.BOTH).build();
        topLevelPanel.add(panelToDisplay, constraints);
        validate();
        pack();
//end of modifiable zone..................E/46aa3c1e-d34e-44eb-beba-7646c87eec74
    }

}
