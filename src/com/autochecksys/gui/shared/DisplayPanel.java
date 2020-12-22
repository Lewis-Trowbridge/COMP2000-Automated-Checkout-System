package com.autochecksys.gui.shared;

import javax.swing.JPanel;

public abstract class DisplayPanel extends JPanel {
    public MainFrame mainFrameToUse;

    public DisplayPanel(MainFrame frameToDisplayIn) {
//begin of modifiable zone(JavaSuper).....C/91cfef97-d38e-4483-b34e-2f3628e871b5

//end of modifiable zone(JavaSuper).......E/91cfef97-d38e-4483-b34e-2f3628e871b5
//begin of modifiable zone................T/3a482217-5049-4e7e-96d3-fbf859f563f8
        this.mainFrameToUse = frameToDisplayIn;
//end of modifiable zone..................E/3a482217-5049-4e7e-96d3-fbf859f563f8
    }

    protected abstract void setUpComponents();

    private void display() {
//begin of modifiable zone................T/07ee780b-ad62-4872-a680-1adafc08e988
        mainFrameToUse.displayPanel(this);
//end of modifiable zone..................E/07ee780b-ad62-4872-a680-1adafc08e988
    }

    public void setupAndDisplay() {
//begin of modifiable zone(JavaCode)......C/808f9c52-0b5b-4f09-8ad5-fce3c1be7d76
        setUpComponents();
        display();
//end of modifiable zone(JavaCode)........E/808f9c52-0b5b-4f09-8ad5-fce3c1be7d76
    }

}
