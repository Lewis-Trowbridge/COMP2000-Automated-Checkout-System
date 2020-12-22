package com.autochecksys.gui.shared;

import java.awt.GridBagConstraints;

public class GridBagConstraintsFactory {
    public GridBagConstraints create(int gridx, int gridy, Integer weightx, Integer weighty, Integer gridwidth, Integer gridheight) {
//begin of modifiable zone................T/9e17cccb-59ad-4ab2-93e9-7f986ec5ee6f
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        constraints.weightx = weightx;
        constraints.weighty = weighty;
        constraints.gridwidth = gridwidth;
        constraints.gridheight = gridheight;
//end of modifiable zone..................E/9e17cccb-59ad-4ab2-93e9-7f986ec5ee6f
//begin of modifiable zone(JavaReturned)..C/bb16de32-3de6-4590-9c23-facd2673bc1d
        return constraints;
//end of modifiable zone(JavaReturned)....E/bb16de32-3de6-4590-9c23-facd2673bc1d
    }

    public GridBagConstraints create(int gridx, int gridy, int weightx, int weighty) {
//begin of modifiable zone(JavaCode)......C/8d04414c-c7f6-4f1a-9f68-f37f5a87c9bd
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        constraints.weightx = weightx;
        constraints.weighty = weighty;
//end of modifiable zone(JavaCode)........E/8d04414c-c7f6-4f1a-9f68-f37f5a87c9bd
//begin of modifiable zone(JavaReturned)..C/8d04414c-c7f6-4f1a-9f68-f37f5a87c9bd
        return constraints;
//end of modifiable zone(JavaReturned)....E/8d04414c-c7f6-4f1a-9f68-f37f5a87c9bd
    }

    public GridBagConstraints create(int gridx, int gridy) {
//begin of modifiable zone(JavaCode)......C/653b5e3c-69bb-4cd7-bfd9-026e92caa831
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = gridx;
        constraints.gridy = gridy;
//end of modifiable zone(JavaCode)........E/653b5e3c-69bb-4cd7-bfd9-026e92caa831
//begin of modifiable zone(JavaReturned)..C/653b5e3c-69bb-4cd7-bfd9-026e92caa831
        return constraints;
//end of modifiable zone(JavaReturned)....E/653b5e3c-69bb-4cd7-bfd9-026e92caa831
    }

}
