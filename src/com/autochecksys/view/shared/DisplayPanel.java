package com.autochecksys.view.shared;

import javax.swing.JPanel;
import com.autochecksys.KeyValuePair;
import com.autochecksys.controller.shared.AbstractController;

public abstract class DisplayPanel extends JPanel {
    public AbstractController controller;

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
//begin of modifiable zone................T/4b7cca5f-beff-47f1-adb6-711be99195c3
        setUpComponents();
        display();
//end of modifiable zone..................E/4b7cca5f-beff-47f1-adb6-711be99195c3
    }

    public abstract void update(KeyValuePair change);

    public void setController(AbstractController controller) {
//begin of modifiable zone................T/895cb13f-5129-4041-ac66-d235704eeb24
        this.controller = controller;
//end of modifiable zone..................E/895cb13f-5129-4041-ac66-d235704eeb24
    }

}
